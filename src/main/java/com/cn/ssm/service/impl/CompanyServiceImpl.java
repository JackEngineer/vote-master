package com.cn.ssm.service.impl;

import com.cn.ssm.dao.SysCompany;
import com.cn.ssm.dao.SysCompanyExample;
import com.cn.ssm.dao.SysCompanyQuery;
import com.cn.ssm.mapping.SysCompanyMapper;
import com.cn.ssm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private SysCompanyMapper sysCompanyMapper;
    @Override
    public Integer AddCompany(SysCompany sysCompany) {
        Date current = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(current);
        sysCompany.setCompanyCreatetime(time);
        return sysCompanyMapper.insert(sysCompany);
    }

    @Override
    public List<SysCompany> list(SysCompanyQuery sysCompany) {
        SysCompanyExample sysCompanyExample=new SysCompanyExample();
        if(sysCompany.getCompanyName()!=null&&!sysCompany.getCompanyName().equals("")){
            sysCompanyExample.createCriteria().andCompanyNameEqualTo(sysCompany.getCompanyName());
        }
        sysCompanyExample.setOrderByClause(" company_id limit "+(sysCompany.getPage()-1)*sysCompany.getRows()+","+sysCompany.getRows());
        List<SysCompany> sysCompanyList=sysCompanyMapper.selectByExample(sysCompanyExample);
        return sysCompanyList;
    }

    @Override
    public Integer deleteCompany(SysCompanyQuery sysCompany) {
        SysCompanyExample sysCompanyExample=new SysCompanyExample();
        sysCompanyExample.createCriteria().andCompanyIdEqualTo(sysCompany.getCompanyId());
        return sysCompanyMapper.deleteByExample(sysCompanyExample);
    }

    @Override
    public long count(SysCompanyQuery sysCompanyQuery) {
        SysCompanyExample sysCompanyExample=new SysCompanyExample();
        if(sysCompanyQuery.getCompanyName()!=null&&!sysCompanyQuery.getCompanyName().equals("")){
            sysCompanyExample.createCriteria().andCompanyNameEqualTo(sysCompanyQuery.getCompanyName());
        }
        return sysCompanyMapper.countByExample(sysCompanyExample);
    }

    @Override
    public Integer updateCompany(SysCompanyQuery sysCompany) {
        return sysCompanyMapper.updateByPrimaryKeySelective(sysCompany);
    }
}
