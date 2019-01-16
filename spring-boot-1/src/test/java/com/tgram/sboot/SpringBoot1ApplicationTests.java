package com.tgram.sboot;

import com.tgram.sboot.domain.User;
import org.apache.catalina.filters.RemoteIpFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tgram.sboot.controller.HelloWorldController;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2019/1/15 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/15 16:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot1ApplicationTests
{

    @Autowired
    private RemoteIpFilter remoteIpFilter;

    @Autowired
    private User user;
    
    // 编写简单的http请求来测试；使用mockmvc进行，利用MockMvcResultHandlers.print()打印出执行结果
    private MockMvc mvc;
    
    /**
     * 通过指定的接口类获取MockMvc对象
     */
    @Before
    public void setUp()
    {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    /**
     * 打印执行的结果
     * @throws Exception 异常
     */
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /**
     * 测试自定义配置properties
     */
    @Test
    public void testProperties()
    {
        System.err.println(remoteIpFilter);
        System.out.println(user);
    }

}
