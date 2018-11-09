package com.cn.ssm.controller;

import com.cn.ssm.dao.*;
import com.cn.ssm.service.ActiveService;
import com.cn.ssm.service.ImgService;
import com.cn.ssm.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by admin on 2018/8/26.
 */
@Controller
@RequestMapping("Prize")
public class PrizeController {
    @Autowired
    PrizeService prizeService;
    @Autowired
    ActiveService activeService;
    @Autowired
    ImgService imgService;
    @RequestMapping(value = "/getPrizeList")
    public @ResponseBody
    Map getPrizeList(SysPrizeQuery sysPrizeQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysPrize> sysPrizeList=prizeService.list(sysPrizeQuery);
        Long count=prizeService.count(sysPrizeQuery);
        SysActiveQuery sysActiveQuery=new SysActiveQuery();
        List<SysActive> sysActiveList=activeService.list(sysActiveQuery);
        result.put("rows",sysPrizeList);
        result.put("ActiveRows",sysActiveList);
        result.put("ActiveRowscount",sysActiveList.size());
        result.put("count",count);
        result.put("errorCode",0);
        return result;
    }

    @RequestMapping(value = "/addPrize")
    public @ResponseBody
    Map addPrize(String prizeName,String prizeContext,String activeName){
        Map<String,Object> result = new HashMap<String, Object>();
        SysPrizeQuery sysPrizeQuery=new SysPrizeQuery();
        sysPrizeQuery.setPrizeName(prizeName);
        Integer numb=prizeService.list(sysPrizeQuery).size();
        if(numb>0){
            result.put("errorCode", 9);
            result.put("errorMessage", "奖品名已存在");
            return result;
        }
        SysPrize sysPrize=new SysPrize();
        SysActiveQuery sysActiveQuery=new SysActiveQuery();
        sysActiveQuery.setActiveName(activeName);
        List<SysActive> sysActiveList=activeService.list(sysActiveQuery);
        sysPrize.setPrizeParentid(sysActiveList.get(0).getActiveId());
        sysPrize.setPrizeContext(prizeContext);
        sysPrize.setPrizeName(prizeName);
        Integer count=prizeService.AddPrize(sysPrize);
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

    @RequestMapping(value = "/deletePrize")
    public @ResponseBody
    Map deletePrize(SysPrize sysPrize){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=prizeService.deletePrize(sysPrize);
        result.put("errorCode",count);
        return result;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map uploadLogo(MultipartFile file, Object scope) {
        Map<String,Object> result = new HashMap<String, Object>();
        String fileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf('.'), fileName.length());
        try {
            FileUtil.uploadFile(file.getBytes(),"/usr/local/img/", newFileName);
        } catch (Exception e) {
            result.put("errorCode", 9);
            result.put("errorMessage", "添加失败");
            return result;
        }
        result.put("errorCode", 0);
        result.put("newFileName", newFileName);
        result.put("errorMessage", "添加成功");
        return result;
    }

    @RequestMapping(value = "/UpdatePrize")
    public @ResponseBody
    Map UpdatePrize(SysPrize sysPrize){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=prizeService.UpdatePrize(sysPrize);
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
