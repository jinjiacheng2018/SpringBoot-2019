package com.tgram.sboot.mapper;

import com.tgram.sboot.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *<p> Description: 持久化层直接继承JpaRepository就会有很多 </p>
 *<p> Copyright: Copyright(c) 2019/1/15 </p>
 *<p> Company: 7qb </p>
 *
 *      dao只要继承JpaRepository类就可以，几乎可以不用写方法，还有一个特别功能非常赞，就是可以根据方法名来自动的生产SQL，
 *      比如findByUserName 会自动生产一个以 userName 为参数的查询方法，比如 findAlll 自动会查询表里面的所有数据，比如自动分页等等。
 *
 *      Entity中不映射成列的字段得加@Transient 注解，不加注解也会映射成列
 *@author JinJiacheng
 *@Version 1.0 2019/1/15 17:04
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

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
     * 更具用户名查询用户信息
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
