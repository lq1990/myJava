package com.mycp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lq
 * create 2019-12-15 12:50
 */
@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_age")
    private Integer userAge;

    /**
     * 配置用户到角色的 多对多关系
     *  1. 声明表关系
     * @ManyToMany 配置多对多关系
     *
     *  2. 配置中间表（包含两个外键）
     * @JoinTable
     *  name：中间表的名称
     *  joinColumns: 配置当前对象在中间表的外键，
     *      @JoinColumn的数组
     *          name: 外键名
     *          referencedColumnName: 参照的主表的主键名
     *
     *  inverseColumns: 配置对方对方在中间表的外键
     *
     * @return
     */
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL) // 多对多关系
    @JoinTable(name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "user_id")}, // joinColumns：当前对象 在中间表中的外键
            inverseJoinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "role_id")} // 对方对象 在中间表中的外键
    ) // 配置中间表
    private Set<Role> roles = new HashSet<Role>();


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", roles=" + roles +
                '}';
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
