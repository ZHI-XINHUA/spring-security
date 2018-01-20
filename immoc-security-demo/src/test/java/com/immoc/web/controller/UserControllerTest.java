package com.immoc.web.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by zhixinhua on 18/1/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user")  //请求路径
               .param("username","james")
                .param("age","18")
                .param("ageTo","30")
                .param("sort","username,asc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))  //请求的编码格式
                .andExpect(MockMvcResultMatchers.status().isOk())  //期望的返回状态
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));//期望返回的内容

        //避免重复写MockMvcRequestBuilders、MockMvcResultMatchers ，可以将它们添加到编译器偏好
    }

}
