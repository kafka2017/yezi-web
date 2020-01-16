package cn.com.yezi.web;

import cn.com.yezi.core.Result;
import cn.com.yezi.core.ResultGenerator;
import cn.com.yezi.model.InquiryCustomer;
import cn.com.yezi.service.InquiryCustomerService;
import org.springframework.stereotype.Controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/01/16.
*/
@Controller
@RequestMapping("/inquiry/customer")
public class InquiryCustomerController {
    @Resource
    private InquiryCustomerService inquiryCustomerService;

    @PostMapping
    public Result add(@RequestBody InquiryCustomer inquiryCustomer) {
        inquiryCustomerService.save(inquiryCustomer);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        inquiryCustomerService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody InquiryCustomer inquiryCustomer) {
        inquiryCustomerService.update(inquiryCustomer);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        InquiryCustomer inquiryCustomer = inquiryCustomerService.findById(id);
        return ResultGenerator.genSuccessResult(inquiryCustomer);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<InquiryCustomer> list = inquiryCustomerService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
