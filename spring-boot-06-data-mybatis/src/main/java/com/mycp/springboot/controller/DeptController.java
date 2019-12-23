package com.mycp.springboot.controller;

import com.mycp.springboot.bean.Department;
import com.mycp.springboot.bean.Employee;
import com.mycp.springboot.mapper.DepartmentMapper;
import com.mycp.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController  不返回页面，而是返回json数据
 *
 * @author lq
 * create 2019-12-18 09:45
 */
@RestController
public class DeptController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {

        return departmentMapper.getDeptById(id);
    }

    /**
     * 在query参数中写  http://localhost:8080/dept?departmentName=aa
     * @param dept
     * @return
     */
    @GetMapping("/dept")
    public Department insertDept(Department dept) {
        departmentMapper.insertDept(dept);
        return dept;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }


}
