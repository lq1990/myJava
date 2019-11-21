package com.mycp.springboot.dao;

import com.mycp.springboot.entities.Department;
import com.mycp.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lq
 * create 2019-11-20 09:58
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        Date date4 = null;
        Date date5 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-01");
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-02");
            date3 = new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-03");
            date4 = new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-04");
            date5 = new SimpleDateFormat("yyyy-MM-dd").parse("1999-09-05");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        employees.put(1001, new Employee(1001, "E-AA", "aa@qq.com", 1, new Department(101, "D-AA"), date1));
        employees.put(1002, new Employee(1002, "E-BB", "bb@qq.com", 1, new Department(102, "D-BB"), date2));
        employees.put(1003, new Employee(1003, "E-CC", "cc@qq.com", 0, new Department(103, "D-CC"), date3));
        employees.put(1004, new Employee(1004, "E-DD", "dd@qq.com", 0, new Department(104, "D-DD"), date4));
        employees.put(1005, new Employee(1005, "E-EE", "ee@qq.com", 1, new Department(105, "D-EE"), date5));

    }

    private static Integer initId = 1006;

    public void save(Employee emp) {
        if (emp.getId() == null ) {
            emp.setId(initId++);
        }

        emp.setDepartment(departmentDao.getDepartment(emp.getDepartment().getId()));
        employees.put(emp.getId(), emp);
    }

    // 查询所有
    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee get(Integer id ) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }


}
