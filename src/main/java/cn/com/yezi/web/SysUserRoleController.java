package cn.com.yezi.web;

import org.springframework.stereotype.Controller;
import cn.com.yezi.core.Result;
import cn.com.yezi.core.ResultGenerator;
import cn.com.yezi.model.SysUserRole;
import cn.com.yezi.service.SysUserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2020/01/16.
*/
@Controller
@RequestMapping("/sys/user/role")
public class SysUserRoleController {
    @Resource
    private SysUserRoleService sysUserRoleService;

    @PostMapping
    public Result add(@RequestBody SysUserRole sysUserRole) {
        sysUserRoleService.save(sysUserRole);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        sysUserRoleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SysUserRole sysUserRole) {
        sysUserRoleService.update(sysUserRole);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        SysUserRole sysUserRole = sysUserRoleService.findById(id);
        return ResultGenerator.genSuccessResult(sysUserRole);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUserRole> list = sysUserRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
