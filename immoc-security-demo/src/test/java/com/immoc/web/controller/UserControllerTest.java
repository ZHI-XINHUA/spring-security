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

    //查询
    @Test
    public void whenQuerySuccess() throws Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")  //get方式请求
               .param("username","james")
                .param("age","18")
                .param("ageTo","30")
                .param("sort","username,asc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))  //请求的编码格式
                .andExpect(MockMvcResultMatchers.status().isOk())  //期望的返回状态
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))//期望返回的内容，长度必须是2
                .andReturn().getResponse().getContentAsString();//获取返回结果 json字符串
        System.out.println("result="+result);

    }

    //获取详情
    @Test
    public  void whenGetInfoSuccess() throws  Exception{
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/lisi")//get请求
        .contentType(MediaType.APPLICATION_JSON_UTF8)) //请求的编码格式
                .andExpect(MockMvcResultMatchers.status().isOk())//期望的返回状态
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("lisi"))//期望username为lisi
                .andReturn().getResponse().getContentAsString();//获取返回结果 json字符串

        System.out.println(result);

    }

}
