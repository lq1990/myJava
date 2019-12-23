package com.mycp.springboot.mapper;

import com.mycp.springboot.bean.Employee;

/**
 * 使用配置文件，而非注解配置
 *
 * @author lq
 * create 2019-12-18 10:39
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

}
