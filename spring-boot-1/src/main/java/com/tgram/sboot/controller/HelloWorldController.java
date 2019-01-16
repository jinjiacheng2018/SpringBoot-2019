package com.tgram.sboot.controller;

import com.tgram.sboot.domain.Employee;
import com.tgram.sboot.service.EmployeeService;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *<p> Description: 接口入口类,注解@RestController=@Controller+@ResponseBody功能</p>
 *<p> Copyright: Copyright(c) 2019/1/15 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/15 15:01
 */
@RestController
public class HelloWorldController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 接口测试：返回JSON字符串
     * @return String
     */
    @RequestMapping(value = "/hello")
    public String hello()
    {
        return "Hello,SpringBoot!!!";
    }

    /**
     * 查询所有的雇员信息
     * @return List<Employee>
     */
    @RequestMapping(value = "/allEmps")
    public List<Employee> allEmps()
    {
        return employeeService.findAll();
    }

    /**
     * 分页排序查询
     * @param page 页码
     * @param size 记录数
     * @return List<Employee>
     */
    @RequestMapping(value = "/queryEmpsPage")
    public List<Employee> queryEmpsPage(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                                        @RequestParam(value = "size",required = false,defaultValue = "3") Integer size)
    {
        Sort sort = new Sort(Sort.Direction.DESC,"empName");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Employee> all = employeeService.findAll(pageable);
        return all.getContent();
    }
}
