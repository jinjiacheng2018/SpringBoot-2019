package com.tgram.sboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *<p> Description: Docker控制层 </p>
 *<p> Copyright: Copyright(c) 2019/1/17 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/17 11:36
 */
@RestController
public class DockerController {

    /**
     * 默认的访问接口
     * @return
     */
    @RequestMapping("/")
    public String index()
    {
        return "Hello,Docker!!!";
    }
}
