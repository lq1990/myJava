package com.mycp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *  1. 实体类和表的映射关系
 *      Entity, Table
 *  2. 类中属性和表中字段的映射关系
 *      Id, GeneratedValue, Column
 *
 * @author lq
 * create 2019-11-29 18:02
 */
@Entity
@Table(name = "cst_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_industry")
    private String custIndustry;

    @Column(name = "cust_level")
    private String custLevel;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_phone")
    private String custPhone;

    @Column(name = "cust_source")
    private String custSource;

    // 配置客户和联系人之间关系：一对多
    /**
     * 使用注解的形式，配置多表关系
     *  1. 声明关系
     * @OneToMany: 配置一对多关系
     *  targetEntity: 对方对象的字节码对象
     *  mappedBy: 可以放弃外键的维护权
     *  cascade: 配置级联（可以配置到设置多表的映射关系的注解上）
     *      CascadeType.ALL 指级联所有操作
             *     PERSIST, 保存
             *     MERGE, 更新
             *     REMOVE, 删除
     *
     *  fetch: 配置关联对象的加载方式
     *      EAGER: 立即加载
     *      LAZY：延迟加载

     *
     * @JoinColumn:
     *  name: 从表的外键名
     *  referencedColumnName: 主表的主键名
     *
     *
     * 注：
     *  在客户实体类上（一的一方）添加了外键，所以对于客户而言，也具备了维护外键的作用。
     *
     *  2. 配置外键
     *
     *  linkMans属性在db的Customer表中是没有的
     *
     */
//    @OneToMany(targetEntity = LinkMan.class)
//    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) // 对方配置关系的属性名称
    private Set<LinkMan> linkMans = new HashSet<LinkMan>();


    public Customer() {

    }

    public Customer(Long custId, String custAddress, String custIndustry, String custLevel, String custName, String custPhone, String custSource) {
        this.custId = custId;
        this.custAddress = custAddress;
        this.custIndustry = custIndustry;
        this.custLevel = custLevel;
        this.custName = custName;
        this.custPhone = custPhone;
        this.custSource = custSource;
    }

    public Set<LinkMan> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<LinkMan> linkMans) {
        this.linkMans = linkMans;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    @Override
    public String toString() {
        return "com.mycp.domain.Customer{" +
                "custId=" + custId +
                ", custAddress='" + custAddress + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custName='" + custName + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custSource='" + custSource + '\'' +
                '}';
    }



}










