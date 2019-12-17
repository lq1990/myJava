package com.mycp.domain;

import javassist.bytecode.annotation.AnnotationMemberValue;

import javax.persistence.*;

/**
 * 联系人实体
 *
 * @author lq
 * create 2019-12-14 09:52
 */
@Entity
@Table(name = "cst_linkman")
public class LinkMan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Long lkmId; // 主键

    @Column(name = "lkm_name")
    private String lkmName;

    @Column(name = "lkm_gender")
    private String lkmGender;

    @Column(name = "lkm_phone")
    private String lkmPhone;

    @Column(name = "lkm_mobile")
    private String lkmMobile;

    @Column(name = "lkm_email")
    private String lkmEmail;

    @Column(name = "lkm_position")
    private String lkmPosition;

    @Column(name = "lkm_memo")
    private String lkmMemo;


    /**
     * 一个联系人对应一个客户。多个联系人 对应 一个客户
     * 1. 配置表关系
     * @ManyToOne: 配置多对一关系
     *  targetEntity: 对方的实体类字节码，即One一方
     *
     *
     * 2. 配置外键（中间表）
     * @JoinColumn: 配置和主表一致
     *  name: 从表的外键名
     *  referencedColumnName：主表的主键名
     *
     *
     *  注意：
     *      配置外键的时候，配置到了多的一方，就会在多的一方维护外键
     *
     *
      */
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    private Customer customer;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "lkmId=" + lkmId +
                ", lkmName='" + lkmName + '\'' +
                ", lkmGender='" + lkmGender + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' +
                ", lkmMobile='" + lkmMobile + '\'' +
                ", lkmEmail='" + lkmEmail + '\'' +
                ", lkmPosition='" + lkmPosition + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                '}';
    }
}
