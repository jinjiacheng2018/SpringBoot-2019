package com.tgram.sboot;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tgram.sboot.domain.Employee;
import com.tgram.sboot.mapper.EmployeeRepository;

/**
 *<p> Description: JPA测试类 </p>
 *<p> Copyright: Copyright(c) 2019/1/15 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/15 17:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(SpringBoot1Application.class)
@SpringBootTest
public class EmployeeRepositoryTest
{
    
    // 自动注入持久化层
    @Autowired
    private EmployeeRepository employeeRepository;
    
    /**
     * 通过持久化类接口对象查询数据
     */
    @Test
    public void testFindEmployee()
    {
        Employee employee1 = employeeRepository.findEmployeeByEmpId(1);
        System.out.println(employee1);
        
        System.out.println("-------------------------------------------------");
        
        List<Employee> employees = employeeRepository.findAll();
        employees.forEach(employee -> System.out.println(employee));
    }
    
    /**
     * 添加条件查询雇员信息
     */
    @Test
    public void testFindEmployee2()
    {
        Employee tom = employeeRepository.findEmployeeByEmpNameEquals("Tom");
        System.out.println(tom);
        
        System.out.println("---------------------------------------------------");
        
        List<Employee> employeeByEmpIdBetween = employeeRepository.findEmployeeByEmpIdBetween(1, 3);
        employeeByEmpIdBetween.forEach(employee -> System.out.println(employee));
    }

    /**
     * 测试排序-根据雇员id进行降序
     */
    @Test
    public void testSort()
    {
        Sort sort = new Sort(Sort.Direction.DESC,"empId");
        List<Employee> all = employeeRepository.findAll(sort);
        all.forEach(employee -> System.out.println(employee));
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testPage()
    {
        // 注意：Pageable的参数page的页数是从0开始，而不是从1，一共就两页（0，1），如果超出了就不会有数据
        // Pageable pageable = new PageRequest(1,2); // 示例方法已经废弃
        Pageable pageable = PageRequest.of(1,2);
        Page<Employee> page = employeeRepository.findAll(pageable);
        List<Employee> content = page.getContent();
        content.forEach(employee -> System.err.println(employee));
        System.out.println(page.getTotalElements() + " -- " + page.getTotalPages());
    }

    /**
     * 测试分页排序
     */
    @Test
    public void testPageAndSort()
    {
        // 创建排序对象
        Sort sort = new Sort(Sort.Direction.DESC,"empAge");

        // 创建分页对象
        Pageable pageable = PageRequest.of(1,3,sort);

        // 查询数据
        Page<Employee> all = employeeRepository.findAll(pageable);
        List<Employee> content = all.getContent();
        content.forEach(employee -> System.err.println(employee));
        System.out.println(all.getTotalElements() + " -- " + all.getTotalPages());
    }
}
