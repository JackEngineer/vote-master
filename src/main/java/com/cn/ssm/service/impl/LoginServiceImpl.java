package com.cn.ssm.service.impl;

import com.cn.ssm.dao.SysUser;
import com.cn.ssm.dao.SysUserExample;
import com.cn.ssm.mapping.SysUserMapper;
import com.cn.ssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    SysUserMapper sysUserMapper;
    public Integer login(String userName, String userPassword) {
        SysUserExample chAnUserExample=new SysUserExample();
        chAnUserExample.createCriteria().andUserNameEqualTo(userName).andUserPasswordEqualTo(userPassword);
        return sysUserMapper.selectByExample(chAnUserExample).size();
    }

    public SysUser selectUser(String name) {
        SysUserExample chAnUserExample=new SysUserExample();
        chAnUserExample.createCriteria().andUserNameEqualTo(name);
        return sysUserMapper.selectByExample(chAnUserExample).get(0);
    }

    public Integer updateUser(String pwd,String name) {
        SysUser chAnUser=new SysUser();
        chAnUser.setUserPassword(pwd);
        SysUserExample chAnUserExample=new SysUserExample();
        chAnUserExample.createCriteria().andUserNameEqualTo(name);
        return sysUserMapper.updateByExampleSelective(chAnUser,chAnUserExample);
    }
}
