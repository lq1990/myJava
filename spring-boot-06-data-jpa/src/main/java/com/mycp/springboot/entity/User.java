package com.mycp.springboot.entity;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;

import javax.persistence.*;

/**
 * 使用JPA注解配置映射关系
 * @Entity 告诉jpa这是一个实体类（和数据表映射的类）
 * @Table 指定和哪个数据表对应；若省略name属性，则为java类名 小写
 *  当db中没有表时，会自动创建table
 *
 * @author lq
 * create 2019-12-18 14:23
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
    @Column(name = "id")
    private Integer id;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column  // 若省略name属性，则默认列名就是属性名
    private String email;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
