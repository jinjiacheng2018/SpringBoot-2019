package com.tgram.sboot.service.impl;

import com.tgram.sboot.domain.Employee;
import com.tgram.sboot.mapper.EmployeeRepository;
import com.tgram.sboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *<p> Description: 数据访问服务实现层 </p>
 *<p> Copyright: Copyright(c) 2019/1/16 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/16 11:17
 */
@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 根据编号查询雇员对象
     * @param empId 雇员id
     * @return Employee对象
     */
    @Override
    public Employee findEmployeeByEmpId(Integer empId)
    {
        return employeeRepository.findEmployeeByEmpId(empId);
    }

    /**
     * 查询所有的雇员信息
     * @return List<Employee>
     */
    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }

    /**
     * 根据用户名查询用户信息
     * @param empName 用户名
     * @return Employee
     */
    @Override
    public Employee findEmployeeByEmpNameEquals(String empName)
    {
        return employeeRepository.findEmployeeByEmpNameEquals(empName);
    }

    /**
     * 范围查询
     * @param startId 开始id
     * @param endId 结束id
     * @return List<Employee>
     */
    @Override
    public List<Employee> findEmployeeByEmpIdBetween(Integer startId, Integer endId)
    {
        return findEmployeeByEmpIdBetween(startId,endId);
    }

    /**
     * 排序查询
     * @param sort
     * @return
     */
    @Override
    public List<Employee> findAll(Sort sort)
    {
        return employeeRepository.findAll(sort);
    }

    /**
     * JPA分页查询
     * @param pageable
     * @return
     */
    @Override
    public Page<Employee> findAll(Pageable pageable)
    {
        return employeeRepository.findAll(pageable);
    }

    /**
     * 通过用户查询雇员信息
     * @param empName
     * @return
     */
    @Override
    public List<Employee> findEmployeeByEmpName(String empName) {
        return employeeRepository.findEmployeeByEmpName(empName);
    }
}
