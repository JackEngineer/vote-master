package com.cn.ssm.service;

import com.cn.ssm.dao.*;

import java.util.List;

public interface InterfaceService {
    //获取学生接口
   List<SysStudent> getStudentList(Integer activeId);

    //获取学生接口
    List<SysStudent> getAllStudentList(Integer activeId);

    //获取活动接口
    List<SysActive> getActiveList(String activeUuid);

    //获取图片
    List<SysImg>  getImg(Integer type,Integer parentId);

    //投票
    Integer vote(String openid,Integer studentid);

   Integer isVote(String openid,Integer studentid);

    //送礼物
    Integer sendGift(SysAccount sysAccount);

    //访问人数
    Integer watchNumb(Integer  activeId);

    Integer selectSum(String activeUuid);

 List<SysStudent> getStudentByName(String studentName,Integer studentId,String activeUuid);

    Integer getStudentRank(String studentName,Integer studentId,String activeUuid);

    List<SysStudent> rankList(String activeUuid);

    List<SysPrize> getPrizeList(String activeUuid);

    Integer addStudent(SysStudent sysStudent,Integer activeId);
}
