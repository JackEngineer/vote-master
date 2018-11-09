package com.cn.ssm.service;


import com.cn.ssm.dao.SysActive;
import com.cn.ssm.dao.SysActiveQuery;
import com.cn.ssm.dao.SysImgQuery;

import java.util.List;

public interface ActiveService {
    Integer AddActive(SysActive sysActive);
    List<SysActive> list(SysActiveQuery sysActiveQuery);
    Integer deleteActive(SysActiveQuery sysActiveQuery);
    Integer deleteActiveImg(SysImgQuery sysImgQuery);
    Integer count(SysActiveQuery sysActiveQuery);
    Integer UpdateActive(SysActiveQuery sysActiveQuery);
    List<SysImgQuery> sysImgLit(SysImgQuery sysImgQuery);
    Long countImg(SysImgQuery sysImgQuery);
}
