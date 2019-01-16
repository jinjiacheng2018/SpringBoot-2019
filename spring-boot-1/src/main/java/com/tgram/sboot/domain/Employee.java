package com.tgram.sboot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *<p> Description: 雇员实体类 </p>
 *<p> Copyright: Copyright(c) 2019/1/15 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/15 16:58
 */
@Entity
//@Table(name = "employee")
public class Employee implements Serializable
{
    @Id
    @GeneratedValue
    private Integer empId; //编号
    
    private String empName; //姓名
    
    private Integer empAge; //年龄
    
    private Date empBirth; //生日
    
    public Employee()
    {
    }
    
    public Employee(Integer empId, String empName, Integer empAge, Date empBirth)
    {
        this.empId = empId;
        this.empName = empName;
        this.empAge = empAge;
        this.empBirth = empBirth;
    }
    
    public Integer getEmpId()
    {
        return empId;
    }
    
    public void setEmpId(Integer empId)
    {
        this.empId = empId;
    }
    
    public String getEmpName()
    {
        return empName;
    }
    
    public void setEmpName(String empName)
    {
        this.empName = empName;
    }
    
    public Integer getEmpAge()
    {
        return empAge;
    }
    
    public void setEmpAge(Integer empAge)
    {
        this.empAge = empAge;
    }
    
    public Date getEmpBirth()
    {
        return empBirth;
    }
    
    public void setEmpBirth(Date empBirth)
    {
        this.empBirth = empBirth;
    }
    
    @Override
    public String toString()
    {
        return "Employee{" + "empId=" + empId + ", empName='" + empName + '\'' + ", empAge=" + empAge + ", empBirth="
                + empBirth + '}';
    }
}
