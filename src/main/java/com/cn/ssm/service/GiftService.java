package com.cn.ssm.service;

import com.cn.ssm.dao.SysGift;
import com.cn.ssm.dao.SysGiftQuery;

import java.util.List;

public interface GiftService {
    Integer AddGift(SysGift sysGift);
    List<SysGift> list(SysGiftQuery sysGiftQuery);
    Integer deleteGift(SysGift sysGift);
    long count(SysGiftQuery sysGiftQuery);
    Integer UpdateGift(SysGift sysGift);
}
