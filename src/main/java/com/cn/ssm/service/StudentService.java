package com.cn.ssm.service;

import com.cn.ssm.dao.SysActive;
import com.cn.ssm.dao.SysActiveQuery;
import com.cn.ssm.dao.SysStudent;
import com.cn.ssm.dao.SysStudentQuery;

import java.util.List;

public interface StudentService {
    Integer AddStudent(SysStudent sysStudent);
    List<SysStudent> list(SysStudentQuery sysStudentQuery);
    Integer deleteStudent(SysStudent sysStudent);
    Integer count(SysStudentQuery sysStudentQuery);
    Integer UpdateStudent(SysStudent sysStudent);
}
