package cn.com.yezi.service.impl;

import cn.com.yezi.core.Result;
import cn.com.yezi.core.ResultGenerator;
import cn.com.yezi.dao.InquiryCustomerMapper;
import cn.com.yezi.model.InquiryCustomer;
import cn.com.yezi.service.InquiryCustomerService;
import cn.com.yezi.core.AbstractService;
import cn.com.yezi.service.SendEmailService;
import cn.com.yezi.util.RegexUtil;
import cn.com.yezi.vo.InquiryCustomerParam;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * Created by CodeGenerator on 2020/01/16.
 */
@Service
public class InquiryCustomerServiceImpl extends AbstractService<InquiryCustomer> implements InquiryCustomerService {


    @Resource
    private InquiryCustomerMapper yzInquiryCustomerMapper;

    @Autowired
    private SendEmailService sendEmailService;


    @Override
    @Transactional
    public Result register(InquiryCustomerParam param) {

        //验证
        Validator validator = new Validator();

        List<ConstraintViolation> ret = validator.validate(param);

        if(!ret.isEmpty()){

            return ResultGenerator.genFailResult(ret.get(0).getMessage());
        }

        String phone = param.getPhone();
        String cusName = param.getCusName();

        Boolean flag = RegexUtil.isChinaPhoneLegal(phone);

        if(!flag){

            return ResultGenerator.genFailResult("手机号码格式错误");
        }

        int count = yzInquiryCustomerMapper.selectInquiryCustomerCount(phone);

        if(count > 0){

            return ResultGenerator.genFailResult("您已经注册过了，我们会尽快联系您");
        }

        InquiryCustomer inquiryCustomer = new InquiryCustomer();
        inquiryCustomer.setCusName(param.getCusName());
        inquiryCustomer.setCompany(param.getCompany());
        inquiryCustomer.setPhone(param.getPhone());
        inquiryCustomer.setRegTime(new Date());
        inquiryCustomer.setRemark(param.getRemark());
        inquiryCustomer.setRegVisit((byte)0);

        int add = yzInquiryCustomerMapper.insert(inquiryCustomer);

        String content = "新用户："+param.getCusName()+","+
                "电话："+param.getPhone()+","+
                "公司单位："+param.getCompany()+","+
                "视频简介："+param.getRemark();

        //发送邮件
        sendEmailService.sendMailMessage("椰子动画新客户询价",content);

        return ResultGenerator.genSuccessResult();
    }
}
