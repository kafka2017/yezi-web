package cn.com.yezi.service.impl;

import cn.com.yezi.dao.InquiryCustomerMapper;
import cn.com.yezi.model.InquiryCustomer;
import cn.com.yezi.service.InquiryCustomerService;
import cn.com.yezi.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/01/16.
 */
@Service
@Transactional
public class InquiryCustomerServiceImpl extends AbstractService<InquiryCustomer> implements InquiryCustomerService {
    @Resource
    private InquiryCustomerMapper yzInquiryCustomerMapper;

}
