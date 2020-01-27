package cn.com.yezi.vo;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

/**
 * @description:
 * @author:wxf
 * @date:2020/1/27
 * @version:
 */
public class InquiryCustomerParam implements Serializable {

    @NotNull(message = "请填写您的称呼")
    @NotEmpty(message = "请填写您的称呼")
    private String cusName;

    @NotNull(message = "请填写您的手机号")
    @NotEmpty(message = "请填写您的手机号")
    private String phone;

    @NotNull(message = "请填写您的公司（单位）")
    @NotEmpty(message = "请填写您的公司（单位）")
    private String company;

    @NotNull(message = "请填写您的视频简介")
    @NotEmpty(message = "请填写您的视频简介")
    private String remark;

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
