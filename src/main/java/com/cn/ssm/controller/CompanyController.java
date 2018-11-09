package com.cn.ssm.controller;

import com.cn.ssm.dao.SysCompany;
import com.cn.ssm.dao.SysCompanyQuery;
import com.cn.ssm.dao.SysUser;
import com.cn.ssm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/addCompany")
    public @ResponseBody
    Map addCompany(SysCompanyQuery sysCompany){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer numb=companyService.list(sysCompany).size();
        if(numb>0){
            result.put("errorCode", 9);
            result.put("errorMessage", "公司名已存在");
            return result;
        }
        Integer count=companyService.AddCompany(sysCompany);
        if(count>0){
            result.put("errorCode", 0);
            result.put("errorMessage", "添加成功");
            return result;
        }else{
            result.put("errorCode",9);
            result.put("errorMessage","添加失败");
            return result;
        }
    }

    @RequestMapping(value = "/getCompanyList")
    public @ResponseBody
    Map getCompanyList(SysCompanyQuery sysCompanyQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysCompany> sysCompanyList=companyService.list(sysCompanyQuery);
        Long count=companyService.count(sysCompanyQuery);
        result.put("rows",sysCompanyList);
        result.put("count",count);
        result.put("errorCode",0);
        return result;
    }

    @RequestMapping(value = "/deleteCompany")
    public @ResponseBody
    Map deleteCompany(SysCompanyQuery sysCompanyQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=companyService.deleteCompany(sysCompanyQuery);
        result.put("errorCode",count);
        return result;
    }

    @RequestMapping(value = "/updateCompany")
    public @ResponseBody
    Map updateCompany(SysCompanyQuery sysCompanyQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=companyService.updateCompany(sysCompanyQuery);
        if(count==1) {
            result.put("errorCode", count);
            result.put("errorMessage", "修改成功");
        }else{
            result.put("errorCode", count);
            result.put("errorMessage", "未知错误");
        }
        return result;
    }
}
