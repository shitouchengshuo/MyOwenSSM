package com.qiqi.juint.controller;

import com.alibaba.fastjson.JSONObject;
import com.qiqi.juint.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by ZhaoQiqi on 2018/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //声明一个ApplicationContext集成测试加载WebApplicationContext，作用是模拟ServletContext
@ContextConfiguration(locations={"classpath:spring/spring-application.xml"})
public class UserTestController {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGetUserInfo() throws Exception {

        MvcResult mvResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/getUser")
                .param("age","12"))
                .andDo(print())
                .andReturn();//最后返回相应的MvcResult

    }

    @Test
    public void testInsertUser() throws Exception {
        User user = new User(77,"萌萌");
        String requestJson = JSONObject.toJSONString(user);
        System.out.println(requestJson);
        MvcResult mvResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/user/insertUser")
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print())
                .andReturn();//最后返回相应的MvcResult
    }
}
