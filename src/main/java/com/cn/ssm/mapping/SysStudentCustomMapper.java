package com.cn.ssm.mapping;

import com.cn.ssm.dao.SysStudent;

import java.util.List;

/**
 * Created by admin on 2018/9/1.
 */
public interface SysStudentCustomMapper {
    Integer selectSum(Integer activeId);
    List<SysStudent> rankList(Integer companyId);
    List<SysStudent> rankListAll(Integer companyId);
}
