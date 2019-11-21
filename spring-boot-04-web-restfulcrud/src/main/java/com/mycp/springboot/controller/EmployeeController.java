package com.mycp.springboot.controller;

import com.mycp.springboot.dao.DepartmentDao;
import com.mycp.springboot.dao.EmployeeDao;
import com.mycp.springboot.entities.Department;
import com.mycp.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author lq
 * create 2019-11-20 15:28
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /*
        查询所有员工
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> emps = employeeDao.getAll();

        model.addAttribute("emps", emps);

        return "emp/list"; // classpath:/templates/+  +.html 交给模板引擎
    }

    // 来到员工添加页面
    // Rest风格，用 get/post/put/delete 区分查 增 改 删
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 来到添加页面前，查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 员工添加功能
    @PostMapping("/emp")
    public String addEmp(Employee employee) { // query中参数与 此方法参数绑定，要去参数名一致
        System.out.println("添加：");
        System.out.println(employee);

        employeeDao.save(employee);
        // 来到员工列表页面
        return "redirect:/emps"; // 不经过视图引擎。而是交给控制器。/是当前项目路径
    }

    // 来到修改页面，查出当前页面，在页面回显。使用PathVar注解 绑定url中的{id}
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee emp = employeeDao.get(id);

        model.addAttribute("emp", emp);

        // 回到修改页面
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    // 员工修改
    @PutMapping("/emp")
    public String updateEmp(Employee employee) {
        System.out.println("修改:");
        System.out.println(employee);

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        System.out.println("删除");
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
