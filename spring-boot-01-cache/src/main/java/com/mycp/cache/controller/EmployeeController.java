package com.mycp.cache.controller;

import com.mycp.cache.bean.Employee;
import com.mycp.cache.service.EmployeeService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lq
 * create 2019-12-19 16:49
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmp(id);
        return emp;
    }

    /**
     * query中参数 传到参数emp中
     * @param emp
     * @return
     */
    @GetMapping("/emp")
    public Employee update(Employee emp) {
        Employee emp1 = employeeService.updateEmp(emp);

        return emp1;
    }

    /**
     *  url:    xxx/delete?id=1
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
        Employee emp = employeeService.getEmpByLastName(lastName);
        return emp;
    }

}
















