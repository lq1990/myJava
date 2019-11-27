package com.mycp.domain;

import javax.persistence.*;

/**
 * 客户实体类
 *  配置映射关系
 *      1. 实体类和表的映射关系， Entity Table注解
 *      2. 实体类中属性 和 表中字段映射关系
 *
 *
 * @Entity 声明实体类
 * @Table 配置实体类和表的映射关系，name属性是配置数据库表的名称
 *
 * @author lq
 * create 2019-11-27 20:25
 */
@Entity
@Table(name = "cst_customer")
public class Customer {

    /**
     * @Id 声明主键的配置
     * @GeneratedValue 配置主键的生成策略
     *   GenerationType.IDENTITY 自增
     * @Column 和表中字段的映射关系
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long custId; // 客户主键

    @Column(name = "cust_name")
    private String custName; // 客户名称

    @Column(name = "cust_source")
    private String custSource; // 客户来源

    @Column(name = "cust_industry")
    private String custIndustry; // 客户所属行业

    @Column(name = "cust_level")
    private String custLevel; // 客户级别

    @Column(name = "cust_address")
    private String custAddress; // 客户地址

    @Column(name = "cust_phone")
    private String custPhone; // 客户电话

    public Customer() {
    }

    public Customer(long custId, String custName, String custSource, String custIndustry, String custLevel, String custAddress, String custPhone) {
        this.custId = custId;
        this.custName = custName;
        this.custSource = custSource;
        this.custIndustry = custIndustry;
        this.custLevel = custLevel;
        this.custAddress = custAddress;
        this.custPhone = custPhone;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
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

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
