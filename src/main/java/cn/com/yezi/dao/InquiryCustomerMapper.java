package cn.com.yezi.dao;

import cn.com.yezi.core.Mapper;
import cn.com.yezi.model.InquiryCustomer;

public interface InquiryCustomerMapper extends Mapper<InquiryCustomer> {

    /**
     * 查询当天注册的用户数量
     * @param phone
     * @return
     */
    public int selectInquiryCustomerCount(String phone);
}