package cn.com.yezi.web;

import cn.com.yezi.core.Result;
import cn.com.yezi.core.ResultGenerator;
import cn.com.yezi.model.InquiryCustomer;
import cn.com.yezi.service.InquiryCustomerService;
import cn.com.yezi.vo.InquiryCustomerParam;
import org.springframework.stereotype.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 询价客户
 */
@Controller
@RequestMapping("/inquiry/customer")
public class InquiryCustomerController {

    @Resource
    private InquiryCustomerService inquiryCustomerService;


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Result register(InquiryCustomerParam param){

        return inquiryCustomerService.register(param);
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Result detail(@PathVariable Integer id) {
        InquiryCustomer inquiryCustomer = inquiryCustomerService.findById(id);
        return ResultGenerator.genSuccessResult(inquiryCustomer);
    }

}
