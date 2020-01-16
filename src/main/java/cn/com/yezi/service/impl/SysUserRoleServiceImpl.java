package cn.com.yezi.service.impl;

import cn.com.yezi.dao.SysUserRoleMapper;
import cn.com.yezi.model.SysUserRole;
import cn.com.yezi.service.SysUserRoleService;
import cn.com.yezi.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2020/01/16.
 */
@Service
@Transactional
public class SysUserRoleServiceImpl extends AbstractService<SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

}
