package com.tgram.sboot.service;

import com.tgram.sboot.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2019/1/16 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/16 11:15
 */
public interface EmployeeService {

    /**
     * 根据编号查询雇员对象
     * @param empId 雇员id
     * @return Employee对象
     */
    Employee findEmployeeByEmpId(Integer empId);

    /**
     * 查询所有的雇员信息
     * @return List<Employee>
     */
    List<Employee> findAll();

    /**
     * 根据用户名查询用户信息
     * @param empName 用户名
     * @return Employee
     */
    Employee findEmployeeByEmpNameEquals(String empName);

    /**
     * 范围查询
     * @param startId 开始id
     * @param endId 结束id
     * @return List<Employee>
     */
    List<Employee> findEmployeeByEmpIdBetween(Integer startId,Integer endId);

    /**
     * 排序查询
     * @param sort
     * @return
     */
    List<Employee> findAll(Sort sort);

    /**
     * JPA分页查询
     * @param pageable
     * @return
     */
    Page<Employee> findAll(Pageable pageable);

}
