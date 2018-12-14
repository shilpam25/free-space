package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.common.TestUtil;
import com.adobe.codingchallenge.model.*;
import com.adobe.codingchallenge.service.BlogService;
import com.adobe.codingchallenge.service.BlogServiceImpl;
import com.adobe.codingchallenge.service.UserService;
import com.adobe.codingchallenge.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserApiTest {

    @InjectMocks
    UserApi userApi;

    MockMvc mockMvc;

    @Mock
    UserService userService;

    @Mock
    BlogService blogService;

    @Before
    public void setup() throws Exception{
        userApi = new UserApi();
        blogService = new BlogServiceImpl();
        userService = new UserServiceImpl();
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(userApi).build();
    }

    @Test
    public void testRegisterUser() throws Exception{
        Mockito.when(userService.registerUser(generateMockUserReq())).thenReturn(generateMockUserDetails());
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/register")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(generateMockUserReq()));
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    public void testLoginUser() throws Exception{
        Mockito.when(userService.checkUserExists(generateMockUserReq())).thenReturn(true);
        Mockito.when(userService.getUserDetails(generateMockUserReq())).thenReturn(generateMockUserDetails());
        Mockito.when(blogService.getAllBlogByUser(Mockito.anyInt())).thenReturn(generateMockListResponse());
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/login")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(generateMockUserReq()));
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    public void testUserDetails() throws Exception{
        Mockito.when(userService.getUserDetails(generateMockUserReq())).thenReturn(generateMockUserDetails());
        Mockito.when(blogService.getAllBlogByUser(Mockito.anyInt())).thenReturn(generateMockListResponse());
        mockMvc.perform(get("/user/{userId}","8")).andExpect(status().isOk());

    }


    private UserReq generateMockUserReq(){
        UserReq userReq = new UserReq();
        userReq.setUserEmail("shilpa@gmail.com");
        userReq.setPwd("abcd");
        return userReq;
    }



    private UserDetails generateMockUserDetails(){
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(8);
        userDetails.setUserEmail("shilpa@gmail.com");
        return userDetails;

    }

    private BlogRes generateMockBlogRes(){
        BlogRes blogRes = new BlogRes();
        blogRes.setCretDt(new Date(System.currentTimeMillis()));
        blogRes.setDesc("My test Blog");
        blogRes.setTitle("Test");
        blogRes.setBlogId(8);
        return blogRes;

    }

    private List<BlogRes> generateMockListResponse() {
        List<BlogRes> blogResList = new ArrayList<>();
        blogResList.add(generateMockBlogRes());
        return blogResList;
    }


}
