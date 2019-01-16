package com.tgram.sboot.config;

import com.tgram.sboot.filter.MyFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *<p> Description: 配置类 </p>
 *<p> Copyright: Copyright(c) 2019/1/15 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/15 15:41
 */
@Configuration
public class WebConfiguration {

    /**
     * 获取RemoteIpFilter的Bean对象
     * @return
     */
    @Bean
    public RemoteIpFilter remoteIpFilter()
    {
        return new RemoteIpFilter();
    }

    /**
     * 获取FilterRegistrationBean的Bean对象注册MyFilter过滤器
     *   原本由xml文件配置，现在转成用配置类进行配置
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("paramName","paramValue");
        registrationBean.setName("MyFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
