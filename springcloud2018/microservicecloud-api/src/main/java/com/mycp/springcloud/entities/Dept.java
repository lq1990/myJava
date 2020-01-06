package com.mycp.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 微服务中 实体类必须实现 序列化。
 *
 * 新建实体类时，get/set constructor 写起来麻烦，尤其是当属性增减时，
 *   使用lombok
 *
 * @author lq
 * create 2020-01-06 10:37
 */
@AllArgsConstructor // 全参构造函数
@NoArgsConstructor // 空参构造函数
@Data // set/get
@Accessors(chain = true) // 访问风格
public class Dept implements Serializable {

    private Long deptno; // 主键
    private String dname; // 部门名称
    /**
     * 来自哪个数据库，微服务架构中一个服务可以对应一个db，
     * 同一个信息被存储到不同数据库
     */
    private String db_source;


    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDname("alix").setDeptno(11L).setDb_source("db01");
        System.out.println(dept);
    }


}
