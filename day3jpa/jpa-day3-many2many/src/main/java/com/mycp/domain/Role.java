package com.mycp.domain;

import org.springframework.transaction.annotation.Transactional;

import javax.naming.Name;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 使用spring jpa的自动创建表的机制
 * 就不手动写sql创建table了。
 *
 * @author lq
 * create 2019-12-15 12:50
 */
@Entity
@Table(name = "sys_role")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;


    @Column(name = "role_name")
    private String roleName;


    // 被动的一方 放弃维护权，使用mappedBy
//    @JoinTable(name = "sys_user_role",
//            joinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "role_id")},
//            inverseJoinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "user_id")})
//    @ManyToMany(targetEntity = User.class)
    @ManyToMany(mappedBy = "roles") // 属性值：对方的属性值名称, 见User 48行
    private Set<User> users = new HashSet<User>();


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                '}';
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
