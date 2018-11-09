package com.cn.ssm.controller;


import com.cn.ssm.dao.SysGift;
import com.cn.ssm.dao.SysGiftQuery;
import com.cn.ssm.dao.SysImg;
import com.cn.ssm.dao.SysStudent;
import com.cn.ssm.service.GiftService;
import com.cn.ssm.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Gift")
public class GiftController {
    @Autowired
    private GiftService giftService;
    @Autowired
    private ImgService imgService;
    @RequestMapping(value = "/getGiftList")
    public @ResponseBody
    Map getGiftList(SysGiftQuery sysGiftQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysGift> sysGifts=giftService.list(sysGiftQuery);
        Long count = giftService.count(sysGiftQuery);
        result.put("rows",sysGifts);
        result.put("errorCode",0);
        result.put("count",count);
        return result;
    }

    @RequestMapping(value = "/addGift")
    public @ResponseBody
    Map addGift(SysGiftQuery sysGiftQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer numb=giftService.list(sysGiftQuery).size();
        if(numb>0){
            result.put("errorCode", 9);
            result.put("errorMessage", "礼物名已存在");
            return result;
        }
        Integer count=giftService.AddGift(sysGiftQuery);
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

    @RequestMapping(value = "/deleteGift")
    public @ResponseBody
    Map deleteGift(SysGift sysGift){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=giftService.deleteGift(sysGift);
        result.put("errorCode",count);
        return result;
    }

    @RequestMapping(value = "/UpdateGift")
    public @ResponseBody
    Map UpdateGift(SysGift sysGift){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=giftService.UpdateGift(sysGift);
        if(count==1) {
            result.put("errorCode", count);
            result.put("errorMessage", "修改成功");
        }else{
            result.put("errorCode", count);
            result.put("errorMessage", "未知错误");
        }
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
    Map getImgUrl(Integer giftId){
        Map<String,Object> result = new HashMap<String, Object>();
        SysImg sysImg=new SysImg();
        sysImg.setImgParentid(giftId);
        sysImg.setImgType(2);
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
}
