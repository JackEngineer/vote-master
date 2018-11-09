package com.cn.ssm.controller;


import com.cn.ssm.dao.*;
import com.cn.ssm.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
    @RequestMapping("Interface")
public class InterfaceController {
   @Autowired
    InterfaceService interfaceService;
   //获取学生
   @RequestMapping(value = "/getStudentList")
   public @ResponseBody
   Map getStudentList(Integer activeId){
       Map<String,Object> result = new HashMap<String, Object>();
       List<SysStudent> sysStudentList=interfaceService.getAllStudentList(activeId);
       result.put("rows",sysStudentList);
       result.put("count",sysStudentList.size());
       result.put("errorCode",0);
       return result;
   }

    //获取活动
    @RequestMapping(value = "/getActiveList")
    public @ResponseBody
    Map getActiveList(String activeUuid){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysActive> sysActiveList=interfaceService.getActiveList(activeUuid);
        result.put("rows",sysActiveList);
        result.put("count",sysActiveList.size());
        result.put("errorCode",0);
        return result;
    }



    //获取活动和学生
    @RequestMapping(value = "/getStudentAndActive")
    public @ResponseBody
    Map getStudentAndActive(String activeUuid){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysActive> sysActiveList=interfaceService.getActiveList(activeUuid);
        List<SysStudent> sysStudentList=interfaceService.getStudentList(sysActiveList.get(0).getActiveId());
        Integer numb=interfaceService.selectSum(activeUuid);
        result.put("sysActiveList",sysActiveList);
        result.put("numb",numb);
        result.put("sysActiveListCount",sysActiveList.size());
        result.put("sysStudentListCount",sysStudentList.size());
        result.put("sysStudentList",sysStudentList);
        result.put("errorMessage","成功");
        result.put("errorCode",0);
        return result;
    }

    //获取图片
    @RequestMapping(value = "/getImg")
    public @ResponseBody
    Map getImg(Integer type,Integer parentId){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysImg> sysImgList=interfaceService.getImg(type,parentId);
        result.put("rows",sysImgList);
        result.put("count",sysImgList.size());
        result.put("errorCode",0);
        return result;
    }

    //投票
    @RequestMapping(value = "/addVote")
    public @ResponseBody
    Map addVote(String openid, Integer studentid){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer isVote=interfaceService.isVote(openid,studentid);
        if(isVote==0) {
            Integer count = interfaceService.vote(openid, studentid);
            if (count == 1) {
                result.put("errorMessage", "投票成功");
            } else {
                result.put("errorMessage", "投票失败");
            }
            result.put("errorCode", 0);
        }else{
            result.put("errorCode",isVote);
            result.put("errorMessage", "投票失败");
        }
            return result;
    }


    //送礼物
    @RequestMapping(value = "/sendGift")
    public @ResponseBody
    Map sendGift(SysAccount sysAccount){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=interfaceService.sendGift(sysAccount);
        if(count==1){
            result.put("errorMessage","赠送成功");
        }else{
            result.put("errorMessage","赠送失败");
        }
        result.put("count",count);
        result.put("errorCode",0);
        return result;
    }

    //访问量
    @RequestMapping(value = "/watchNumb")
    public @ResponseBody
    Integer watchNumb(Integer activeId){
      return interfaceService.watchNumb(activeId);
    }

    //搜索学生
    @RequestMapping(value = "/getStudentByName")
    public @ResponseBody
    Map getStudentByName(String studentName,Integer studentId,String activeUuid){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysStudent> list=interfaceService.getStudentByName(studentName,studentId,activeUuid);
        if(studentName.trim()!=""&&studentId!=null){
            Integer rankNumb=interfaceService.getStudentRank(studentName,studentId,activeUuid);
            result.put("studentRank",rankNumb);
        }
        result.put("rows",list);
        result.put("errorCode",0);
        return result;
    }

    //学生报名
    @RequestMapping(value = "/addStudent")
    public @ResponseBody
    Integer addStudent(SysStudent sysStudent,Integer activeId){
        return interfaceService.addStudent(sysStudent,activeId);
    }

    //获取排行榜
    @RequestMapping(value = "/getRankList")
    public @ResponseBody
    Map getRankList(String activeUuid){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysStudent> rankList=interfaceService.rankList(activeUuid);
        result.put("rankList",rankList);
        result.put("errorMessage","成功");
        result.put("errorCode",0);
        return result;
    }

    //获取奖品
    @RequestMapping(value = "/getPrizeList")
    public @ResponseBody
    Map getPrizeList(String activeUuid){
        Map<String,Object> result =new HashMap<String, Object>();
        List<SysPrize> sysPrizes=interfaceService.getPrizeList(activeUuid);
        result.put("sysPrizes",sysPrizes);
        result.put("errorMessage","成功");
        result.put("errorCode",0);
        return result;
    }
}
