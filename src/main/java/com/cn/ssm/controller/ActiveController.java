package com.cn.ssm.controller;


import com.cn.ssm.dao.*;
import com.cn.ssm.service.ActiveService;
import com.cn.ssm.service.CompanyService;
import com.cn.ssm.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("Active")
public class ActiveController {
    @Autowired
    private ActiveService activeService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ImgService imgService;
    @RequestMapping("/upload")
    @ResponseBody
    public Map uploadLogo(MultipartFile file) throws IOException {
        Map<String,Object> result = new HashMap<String, Object>();
        String fileName = file.getOriginalFilename();
        String  strh = fileName.substring(fileName.length() -3,fileName.length());   //截取
        if(strh.trim().equals("jpg")||strh.trim().equals("png")) {
//            String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf('.'), fileName.length());
            try {
                FileUtil.uploadFile(file.getBytes(), "/usr/local/img/", fileName);
            } catch (Exception e) {
                result.put("errorCode", 9);
                result.put("errorMessage", "添加失败");
                return result;
            }
            result.put("errorCode", 0);
            result.put("newFileName", fileName);
            result.put("errorMessage", "添加成功");
            return result;
        }else{
            result.put("errorCode", 9);
            result.put("errorMessage", "只支持png和jpg格式");
            return result;
        }
    }


    @RequestMapping(value = "/getActiveList")
    public @ResponseBody
    Map getActiveList(SysActiveQuery sysActiveQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysActive> sysActiveList=activeService.list(sysActiveQuery);
        Integer count = activeService.count(sysActiveQuery);
        SysCompanyQuery sysCompanyQuery=new SysCompanyQuery();
        List<SysCompany> sysCompanyList=companyService.list(sysCompanyQuery);
        result.put("rows",sysActiveList);
        result.put("CompanyRows",sysCompanyList);
        result.put("CompanyRowscount",sysCompanyList.size());
        result.put("count",count);
        result.put("errorCode",0);
        return result;
    }

    @RequestMapping(value = "/addImg")
    public @ResponseBody
    Map addImg(SysImg sysImg){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=imgService.AddImg(sysImg);
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

    @RequestMapping(value = "/getImgUrl")
    public @ResponseBody
    Map getImgUrl(Integer activeId){
        Map<String,Object> result = new HashMap<String, Object>();
        SysImg sysImg=new SysImg();
        sysImg.setImgParentid(activeId);
        sysImg.setImgType(1);
        SysImg sysImg1=imgService.getImgUrl(sysImg);
        if(sysImg1!=null){
            result.put("errorCode", 0);
            result.put("row", sysImg1);
            return result;
        }else {
            result.put("errorCode",9);
            result.put("errorMessage","");
            return result;
        }
    }


    @RequestMapping(value = "/addActive")
    public @ResponseBody
    Map addCompany(SysActiveQuery sysActive){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer numb=activeService.list(sysActive).size();
        if(numb>0){
            result.put("errorCode", 9);
            result.put("errorMessage", "活动名已存在");
            return result;
        }
        SysCompanyQuery sysCompanyQuery=new SysCompanyQuery();
        sysCompanyQuery.setCompanyName(sysActive.getActiveCompanyid());
        List<SysCompany> sysCompanyList=companyService.list(sysCompanyQuery);
        sysActive.setActiveCompanyid(sysCompanyList.get(0).getCompanyId().toString());
        Integer count=activeService.AddActive(sysActive);
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

    @RequestMapping(value = "/deleteActive")
    public @ResponseBody
    Map deleteActive(SysActiveQuery sysActiveQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=activeService.deleteActive(sysActiveQuery);
        result.put("errorCode",count);
        return result;
    }

    @RequestMapping(value = "/deleteActiveImg")
    public @ResponseBody
    Map deleteActiveImg(SysImgQuery sysImgQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=activeService.deleteActiveImg(sysImgQuery);
        result.put("errorCode",count);
        return result;
    }
    @RequestMapping(value = "/UpdateActive")
    public @ResponseBody
    Map UpdateActive(SysActiveQuery sysActiveQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=activeService.UpdateActive(sysActiveQuery);
        if(count==1) {
            result.put("errorCode", count);
            result.put("errorMessage", "修改成功");
        }else{
            result.put("errorCode", count);
            result.put("errorMessage", "未知错误");
        }
        return result;
    }

    @RequestMapping(value = "/getActiveImgList")
    public @ResponseBody
    Map getActiveImgList(SysImgQuery sysImgQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysImgQuery> sysImgQueries=activeService.sysImgLit(sysImgQuery);
        Long count = activeService.countImg(sysImgQuery);
        result.put("rows",sysImgQueries);
        result.put("count",count);
        result.put("errorCode",0);
        return result;
    }

}
