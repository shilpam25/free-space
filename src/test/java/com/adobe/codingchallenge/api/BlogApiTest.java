package com.adobe.codingchallenge.api;

import com.adobe.codingchallenge.common.TestUtil;
import com.adobe.codingchallenge.model.BlogReq;
import com.adobe.codingchallenge.model.BlogRes;
import com.adobe.codingchallenge.service.BlogService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class BlogApiTest {
    @InjectMocks
    BlogApi blogApi;

    @Mock
    BlogService blogService;

    MockMvc mockMvc;
    @Before
    public void setup() throws Exception{
        blogApi = new BlogApi();
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(blogApi).build();
    }
    @Test
    public void testSaveBlog() throws Exception{
        Mockito.when(blogService.saveBlog(generateMockBlogReq())).thenReturn(generateMockBlogRes());
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/user/save-blog")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(generateMockBlogReq()));
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    public void testPublishBlog() throws Exception{
        Mockito.doNothing().when(blogService).publishBlog(Mockito.anyInt());
        mockMvc.perform(put("/user/publish-blog/{blogId}","8")).andExpect(status().isOk());
    }

    @Test
    public void testGetBlogsRes() throws Exception{
        Mockito.when(blogService.getBlogs()).thenReturn(generateMockListResponse());
        MockHttpServletRequestBuilder builder = get("/blog/blogs")
                .contentType(TestUtil.APPLICATION_JSON_UTF8);
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    public void testGetBlogDetails() throws Exception{
        Mockito.when(blogService.getBlogDetails(Mockito.anyInt())).thenReturn(generateMockBlogRes());
        mockMvc.perform(get("/blog/blogDetails/{blogId}","8")).andExpect(status().isOk());
    }

    @Test
    public void testRemoveUserBlog() throws Exception{
        Mockito.doNothing().when(blogService).deleteBlog(Mockito.anyInt(), Mockito.anyInt());
        mockMvc.perform(delete("/user/{userId}/blog/{blogId}","8","10")).andExpect(status().isOk());
    }

    private BlogReq generateMockBlogReq(){
        BlogReq blogReq = new BlogReq();
        blogReq.setBlogId(8);
        blogReq.setDesc("My test Blog");
        blogReq.setTitle("Test");
        blogReq.setUserId(10);
        return blogReq;
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
