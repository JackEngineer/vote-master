package com.cn.ssm.service;

import com.cn.ssm.dao.SysCompany;
import com.cn.ssm.dao.SysCompanyQuery;

import java.util.List;

public interface CompanyService {
    Integer AddCompany(SysCompany sysCompany);
    List<SysCompany> list(SysCompanyQuery sysCompany);
    Integer deleteCompany(SysCompanyQuery sysCompany);
    long count(SysCompanyQuery sysCompanyQuery);
    Integer updateCompany(SysCompanyQuery sysCompany);
}
