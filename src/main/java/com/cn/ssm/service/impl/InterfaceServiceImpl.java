package com.cn.ssm.service.impl;

import com.cn.ssm.controller.Base64;
import com.cn.ssm.dao.*;
import com.cn.ssm.mapping.*;
import com.cn.ssm.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class InterfaceServiceImpl implements InterfaceService {
    @Autowired
    SysStudentMapper studentMapper;
    @Autowired
    SysActiveMapper sysActiveMapper;
    @Autowired
    SysImgMapper sysImgMapper;
    @Autowired
    SysTicketMapper sysTicketMapper;
    @Autowired
    SysAccountMapper sysAccountMapper;
    @Autowired
    SysWatchMapper sysWatchMapper;
    @Autowired
    SysStudentCustomMapper sysStudentCustomMapper;
    @Autowired
    SysPrizeMapper sysPrizeMapper;
    @Autowired
    SysGiftMapper sysGiftMapper;
    public Integer getId(String activeUuid){
        SysActiveExample sysActiveExample=new SysActiveExample();
        sysActiveExample.createCriteria().andActiveUuidEqualTo(activeUuid);
       return sysActiveMapper.selectByExample(sysActiveExample).get(0).getActiveId();
    }
    @Override
    public List<SysStudent> getStudentList(Integer activeId) {
        SysStudentExample sysStudentExample=new SysStudentExample();
        sysStudentExample.createCriteria().andStudentActiveidEqualTo(activeId.toString());
        sysStudentExample.setOrderByClause(" student_id limit 0,10");
        List<SysStudent> sysStudents=studentMapper.selectByExample(sysStudentExample);
        return sysStudents;
    }

    @Override
    public List<SysStudent> getAllStudentList(Integer activeId) {
        SysStudentExample sysStudentExample=new SysStudentExample();
        sysStudentExample.createCriteria().andStudentActiveidEqualTo(activeId.toString());
        List<SysStudent> sysStudents=studentMapper.selectByExample(sysStudentExample);
        return sysStudents;
    }

    @Override
    public Integer selectSum(String activeUuid) {
        Integer activeId=getId(activeUuid);
        Integer numb=sysStudentCustomMapper.selectSum(activeId);
        return numb;
    }

    @Override
    public List<SysStudent> getStudentByName(String studentName,Integer studentId,String activeUuid) {
        SysStudentExample sysStudentExample=new SysStudentExample();
        if(studentName.trim()==""&&studentId==null){
            Integer activeId=getId(activeUuid);
            sysStudentExample.createCriteria().andStudentActiveidEqualTo(activeId.toString());
        }
        if(studentName.trim()!=""&&studentId!=null) {
            sysStudentExample.createCriteria().andStudentNameLike("%"+studentName.trim()+"%").andStudentIdEqualTo(studentId);
        }
        if(studentName.trim()!=""&&studentId==null){
            sysStudentExample.createCriteria().andStudentNameLike("%"+studentName.trim()+"%");
        }
        if(studentName.trim()==""&&studentId!=null){
            sysStudentExample.createCriteria().andStudentIdEqualTo(studentId);
        }
        List<SysStudent> list=studentMapper.selectByExample(sysStudentExample);
        if(list.size()>=1){
            return list;
        }else{
            return null;
        }
    }

    @Override
    public Integer getStudentRank(String studentName, Integer studentId, String activeUuid) {
        Integer rankNumb=null;
        List<SysStudent> sysStudents=rankList(activeUuid);
        for(int i=0;i<sysStudents.size();i++){
            String name=sysStudents.get(i).getStudentName();
            if(name.equals(studentName)){
                rankNumb=i+1;
            }
        }
        return rankNumb;
    }

    @Override
    public List<SysStudent> rankList(String activeUuid) {
        Integer id=getId(activeUuid);
        return sysStudentCustomMapper.rankList(id);
    }

    @Override
    public List<SysPrize> getPrizeList(String activeUuid) {
        SysPrizeExample sysPrizeExample=new SysPrizeExample();
        if(activeUuid!=null) {
            Integer id=getId(activeUuid);
            sysPrizeExample.createCriteria().andPrizeParentidEqualTo(id);
        }
        List<SysPrize> sysPrizes=sysPrizeMapper.selectByExample(sysPrizeExample);
        if(sysPrizes.size()>=1){
            return sysPrizes;
        }else{
            return null;
        }
    }

    @Override
    public Integer addStudent(SysStudent sysStudent,Integer activeId) {
        SysStudentExample sysStudentExample=new SysStudentExample();
        sysStudentExample.createCriteria().andStudentActiveidEqualTo(activeId.toString());
        List<SysStudent> sysStudents=studentMapper.selectByExample(sysStudentExample);
        if(sysStudents==null){
            sysStudent.setStudentNumb("1号选手");
        }else{
            sysStudent.setStudentNumb(sysStudents.size()+1+"号选手");
        }
        Base64.GenerateImage(sysStudent.getStudentImg(), "/usr/local/img/"+sysStudent.getStudentName()+".jpg");
        sysStudent.setStudentActiveid(activeId.toString());
        sysStudent.setStudentImg("/img/"+sysStudent.getStudentName()+".jpg");
        return studentMapper.insert(sysStudent);
    }

    @Override
    public List<SysActive> getActiveList(String activeUuid) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        SysActiveExample sysActiveExample=new SysActiveExample();
        sysActiveExample.createCriteria().andActiveUuidEqualTo(activeUuid).andActiveBegintimeLessThanOrEqualTo(dateString).andActiveEndtimeGreaterThanOrEqualTo(dateString);
        List<SysActive> sysActiveList=sysActiveMapper.selectByExample(sysActiveExample);
        return sysActiveList;
    }

    @Override
    public List<SysImg> getImg(Integer type,Integer parentId) {
        SysImgExample sysImgExample=new SysImgExample();
        sysImgExample.createCriteria().andImgParentidEqualTo(parentId).andImgTypeEqualTo(type);
        return sysImgMapper.selectByExample(sysImgExample);
    }

    @Override
    public Integer vote(String openid, Integer studentid) {
        SysStudent sysStudent=studentMapper.selectByPrimaryKey(studentid);
        sysStudent.setStudentTicket(sysStudent.getStudentTicket()+1);
        studentMapper.updateByPrimaryKeySelective(sysStudent);
        SysTicket sysTicket = new SysTicket();
        sysTicket.setTicketNumb(1);
        sysTicket.setTicketOpenid(openid);
        sysTicket.setTicketStudentid(studentid);
        sysTicket.setTicketTime(new Date());
        return sysTicketMapper.insert(sysTicket);
    }

    @Override
    public Integer isVote(String openid, Integer studentid) {
        Date date=new   Date(); //取时间
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date);
        cal2.setTime(date);
// 将时分秒,毫秒域清零
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.HOUR_OF_DAY, 23);
        cal1.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.MINUTE, 59);
        cal1.set(Calendar.SECOND, 0);
        cal2.set(Calendar.SECOND, 59);
        SysTicketExample sysTicketExample=new SysTicketExample();
        sysTicketExample.createCriteria().andTicketOpenidEqualTo(openid).andTicketStudentidEqualTo(studentid).andTicketTimeBetween(cal1.getTime(),cal2.getTime());
        List<SysTicket> sysTickets=sysTicketMapper.selectByExample(sysTicketExample);
        if(sysTickets.size()==0){
            SysTicketExample sysTicketExample1=new SysTicketExample();
            sysTicketExample1.createCriteria().andTicketOpenidEqualTo(openid).andTicketTimeBetween(cal1.getTime(),cal2.getTime());
            List<SysTicket> sysTickets1=sysTicketMapper.selectByExample(sysTicketExample1);
            if(sysTickets1!=null){
                if(sysTickets1.size()>=3){
                    return 8;
                }else{
                    return 0;
                }
            }else {
                return 0;
            }
        }else{
         return 7;
        }
    }

    @Override
    public Integer sendGift(SysAccount sysAccount) {
        sysAccount.setAccountTime(new Date());
        sysAccount.setAccountType(1);
        Integer studentId=sysAccount.getAccountStudentid();
        Integer prize=sysAccount.getAccountAmt();
        SysStudent sysStudent=studentMapper.selectByPrimaryKey(studentId);
        SysGift sysGift=sysGiftMapper.selectByPrimaryKey(sysAccount.getAccountGiftid());
        if(prize==2){
            sysStudent.setStudentTicket(sysStudent.getStudentTicket()+sysGift.getGiftTicket()*sysAccount.getAccountNumb());
        }
        if(prize==5){
            sysStudent.setStudentTicket(sysStudent.getStudentTicket()+sysGift.getGiftTicket()*sysAccount.getAccountNumb());
        }
        if(prize==10){
            sysStudent.setStudentTicket(sysStudent.getStudentTicket()+sysGift.getGiftTicket()*sysAccount.getAccountNumb());
        }
        if(prize==50){
            sysStudent.setStudentTicket(sysStudent.getStudentTicket()+sysGift.getGiftTicket()*sysAccount.getAccountNumb());
        }
        studentMapper.updateByPrimaryKeySelective(sysStudent);
        return sysAccountMapper.insert(sysAccount);
    }

    @Override
    public Integer watchNumb(Integer activeId) {
        SysWatchExample sysWatchExample=new SysWatchExample();
        sysWatchExample.createCriteria().andWatchActiveidEqualTo(activeId);
        List<SysWatch> sysWatches=sysWatchMapper.selectByExample(sysWatchExample);
        SysWatch sysWatch=new SysWatch();
        sysWatch.setWatchNumb(sysWatches.get(0).getWatchNumb()+1);
        sysWatch.setWatchActiveid(activeId);
        sysWatch.setId(sysWatches.get(0).getId());
        sysWatchMapper.updateByPrimaryKeySelective(sysWatch);
        return sysWatches.get(0).getWatchNumb()+1;
    }

}
