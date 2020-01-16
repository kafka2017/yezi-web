package cn.com.yezi.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "yz_inquiry_customer")
public class InquiryCustomer {
    /**
     * 主键id
     */
    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 客户名称
     */
    @Column(name = "cus_name")
    private String cusName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 公司（单位）
     */
    private String company;

    /**
     * 简介
     */
    private String remark;

    /**
     * 注册时间
     */
    @Column(name = "reg_time")
    private Date regTime;

    /**
     * 回访状态 (0 未回访 1 已回访)
     */
    @Column(name = "reg_visit")
    private Byte regVisit;

    /**
     * 获取主键id
     *
     * @return customer_id - 主键id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置主键id
     *
     * @param customerId 主键id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取客户名称
     *
     * @return cus_name - 客户名称
     */
    public String getCusName() {
        return cusName;
    }

    /**
     * 设置客户名称
     *
     * @param cusName 客户名称
     */
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取公司（单位）
     *
     * @return company - 公司（单位）
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置公司（单位）
     *
     * @param company 公司（单位）
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取简介
     *
     * @return remark - 简介
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置简介
     *
     * @param remark 简介
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取注册时间
     *
     * @return reg_time - 注册时间
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * 设置注册时间
     *
     * @param regTime 注册时间
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * 获取回访状态 (0 未回访 1 已回访)
     *
     * @return reg_visit - 回访状态 (0 未回访 1 已回访)
     */
    public Byte getRegVisit() {
        return regVisit;
    }

    /**
     * 设置回访状态 (0 未回访 1 已回访)
     *
     * @param regVisit 回访状态 (0 未回访 1 已回访)
     */
    public void setRegVisit(Byte regVisit) {
        this.regVisit = regVisit;
    }
}