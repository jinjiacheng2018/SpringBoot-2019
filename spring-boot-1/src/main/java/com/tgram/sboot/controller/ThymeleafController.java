package com.tgram.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgram.sboot.domain.Employee;
import com.tgram.sboot.service.EmployeeService;

/**
 *<p> Description: 使用它Thymeleaf模版引擎渲染页面 </p>
 *<p> Copyright: Copyright(c) 2019/1/16 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/16 15:24
 */
@Controller
public class ThymeleafController {

    private final String SUCCESS = "success";

    @Autowired
    private EmployeeService employeeService;

    /**
     * 访问success.html页面，路径：classpath:templates/xxx.html
     * @return
     */
    @RequestMapping(value = "/page")
    public String successPage(Model model)
    {
        model.addAttribute("allEmps",employeeService.findAll());
        return SUCCESS;
    }

    /**
     * 分页查询数据
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping(value = "/page/{page}/{size}")
    public String queryEmpsPage(@PathVariable(value = "page",required = false) Integer page,
                                @PathVariable(value = "size",required = false) Integer size,
                                Model model)
    {
        Pageable pageable = PageRequest.of(page,size);
        Page<Employee> all = employeeService.findAll(pageable);
        model.addAttribute("allEmps",all.getContent());
        return SUCCESS;
    }
}
