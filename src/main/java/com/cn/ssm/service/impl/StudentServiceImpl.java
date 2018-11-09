package com.cn.ssm.service.impl;

import com.cn.ssm.dao.SysStudent;
import com.cn.ssm.dao.SysStudentExample;
import com.cn.ssm.dao.SysStudentQuery;
import com.cn.ssm.mapping.SysStudentMapper;
import com.cn.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    SysStudentMapper studentMapper;
    @Override
    public Integer AddStudent(SysStudent sysStudent) {
        SysStudentExample sysStudentExample=new SysStudentExample();
        sysStudentExample.createCriteria().andStudentActiveidEqualTo(sysStudent.getStudentActiveid());
        List<SysStudent> sysStudents=studentMapper.selectByExample(sysStudentExample);
        if(sysStudents==null){
            sysStudent.setStudentNumb("1号选手");
        }else{
            sysStudent.setStudentNumb(sysStudents.size()+1+"号选手");
        }
        sysStudent.setStudentTicket(0);
        return studentMapper.insert(sysStudent);
    }

    @Override
    public List<SysStudent> list(SysStudentQuery sysStudentQuery) {
        SysStudentExample sysStudentExample=new SysStudentExample();
        if(sysStudentQuery.getStudentName()!=null&&!sysStudentQuery.getStudentName().equals("")){
            sysStudentExample.createCriteria().andStudentNameLike(sysStudentQuery.getStudentName().trim());
        }
        sysStudentExample.setOrderByClause(" student_id limit "+(sysStudentQuery.getPage()-1)*sysStudentQuery.getRows()+","+sysStudentQuery.getRows());
        return studentMapper.selectByExample(sysStudentExample);
    }

    @Override
    public Integer deleteStudent(SysStudent sysStudent) {
        return studentMapper.deleteByPrimaryKey(sysStudent.getStudentId());
    }

    @Override
    public Integer count(SysStudentQuery sysStudentQuery) {
        SysStudentExample sysStudentExample=new SysStudentExample();
        if(sysStudentQuery.getStudentName()!=null&&!sysStudentQuery.getStudentName().equals("")){
            sysStudentExample.createCriteria().andStudentNameLike(sysStudentQuery.getStudentName().trim());
        }
        return studentMapper.countByExample(sysStudentExample);
    }

    @Override
    public Integer UpdateStudent(SysStudent sysStudent) {
        return studentMapper.updateByPrimaryKeySelective(sysStudent);
    }
}
