package cn.com.yezi.service;
import cn.com.yezi.core.Result;
import cn.com.yezi.model.InquiryCustomer;
import cn.com.yezi.core.Service;
import cn.com.yezi.vo.InquiryCustomerParam;


/**
 * Created by CodeGenerator on 2020/01/16.
 */
public interface InquiryCustomerService extends Service<InquiryCustomer> {

    /**
     * 询价客户注册
     * @param param
     * @return
     */
    public Result register(InquiryCustomerParam param);

}
