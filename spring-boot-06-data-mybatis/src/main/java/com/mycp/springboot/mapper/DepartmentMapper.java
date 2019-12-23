package com.mycp.springboot.mapper;

import com.mycp.springboot.bean.Department;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.javassist.bytecode.DeprecatedAttribute;

/**
 * 指定这是一个操作db的mapper
 *
 * 使用注解配置
 *
 * @author lq
 * create 2019-12-18 09:33
 */
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id") // 会使用生成的key，然后主键是id
    @Insert("insert into department (department_name) values (#{departmentName})")
    public int insertDept(Department dept);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department dept);


}
