package com.cn.ssm.service;


import com.cn.ssm.dao.SysUser;

public interface LoginService {
    Integer login(String userName, String userPassword);
    SysUser selectUser(String name);
    Integer updateUser(String pwd,String name);
}
