package com.adobe.codingchallenge.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class CommentApiTest {

    @InjectMocks
    CommentApi commentApi;

    MockMvc mockMvc;

    @Before
    public void setup() throws Exception{
        commentApi = new CommentApi();
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(commentApi).build();
    }

    @Test
    public void testPostComment() throws Exception{


    }

    @Test
    public void testDeleteAllCommentByUser() throws Exception{

    }

    @Test
    public void testDeleteAllCommentByBlog() throws Exception{

    }

    @Test
    public void testDeleteCommentByUser() throws Exception{

    }

    @Test
    public void testGetAllCommentByUser() throws Exception{

    }

    @Test
    public void testGetAllCommentByBlog()throws Exception{

    }


}
