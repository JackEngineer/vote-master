package com.cn.ssm.controller;


import com.cn.ssm.dao.*;
import com.cn.ssm.service.ActiveService;
import com.cn.ssm.service.ImgService;
import com.cn.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    ActiveService activeService;
    @Autowired
    ImgService imgService;
    @RequestMapping(value = "/getStudentList")
    public @ResponseBody
    Map getStudentList(SysStudentQuery sysStudentQuery){
        Map<String,Object> result = new HashMap<String, Object>();
        List<SysStudent> sysStudentQueries=studentService.list(sysStudentQuery);
        Integer count=studentService.count(sysStudentQuery);
        SysActiveQuery sysActiveQuery=new SysActiveQuery();
        List<SysActive> sysActiveList=activeService.list(sysActiveQuery);
        result.put("rows",sysStudentQueries);
        result.put("ActiveRows",sysActiveList);
        result.put("ActiveRowscount",sysActiveList.size());
        result.put("count",count);
        result.put("errorCode",0);
        return result;
    }


    @RequestMapping(value = "/deleteStudent")
    public @ResponseBody
    Map deleteStudent(SysStudent sysStudent){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=studentService.deleteStudent(sysStudent);
        result.put("errorCode",count);
        return result;
    }

    @RequestMapping(value = "/addStudent")
    public @ResponseBody
    Map addStudent(SysStudent sysStudent){
        Map<String,Object> result = new HashMap<String, Object>();
        SysActiveQuery sysActiveQuery=new SysActiveQuery();
        sysActiveQuery.setActiveName(sysStudent.getStudentActiveid());
        List<SysActive> sysActiveList=activeService.list(sysActiveQuery);
        sysStudent.setStudentActiveid(sysActiveList.get(0).getActiveId().toString());
        Integer count=studentService.AddStudent(sysStudent);
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

    @RequestMapping("/upload")
    @ResponseBody
    public Map uploadLogo(MultipartFile file) {
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
    Map getImgUrl(Integer studentId){
        Map<String,Object> result = new HashMap<String, Object>();
        SysImg sysImg=new SysImg();
        sysImg.setImgParentid(studentId);
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

    @RequestMapping(value = "/UpdateStudent")
    public @ResponseBody
    Map UpdateStudent(SysStudent sysStudent){
        Map<String,Object> result = new HashMap<String, Object>();
        Integer count=studentService.UpdateStudent(sysStudent);
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
