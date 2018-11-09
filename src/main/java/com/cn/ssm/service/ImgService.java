package com.cn.ssm.service;

import com.cn.ssm.dao.SysImg;

public interface ImgService {
    Integer AddImg(SysImg sysImg);
    SysImg getImgUrl(SysImg sysImg);
}
