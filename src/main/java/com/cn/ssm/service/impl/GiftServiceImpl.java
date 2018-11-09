package com.cn.ssm.service.impl;

import com.cn.ssm.dao.SysGift;
import com.cn.ssm.dao.SysGiftExample;
import com.cn.ssm.dao.SysGiftQuery;
import com.cn.ssm.mapping.SysGiftMapper;
import com.cn.ssm.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftServiceImpl implements GiftService {
    @Autowired
    private SysGiftMapper sysGiftMapper;

    @Override
    public Integer AddGift(SysGift sysGift) {
        return sysGiftMapper.insert(sysGift);
    }

    @Override
    public List<SysGift> list(SysGiftQuery sysGiftQuery) {
        SysGiftExample sysActiveExample=new SysGiftExample();
        if(sysGiftQuery.getGiftName()!=null&&!sysGiftQuery.getGiftName().equals("")){
            sysActiveExample.createCriteria().andGiftNameEqualTo(sysGiftQuery.getGiftName().trim());
        }
        sysActiveExample.setOrderByClause(" gift_id limit "+(sysGiftQuery.getPage()-1)*sysGiftQuery.getRows()+","+sysGiftQuery.getRows());
        return sysGiftMapper.selectByExample(sysActiveExample);
    }

    @Override
    public Integer deleteGift(SysGift sysGift) {
        return sysGiftMapper.deleteByPrimaryKey(sysGift.getGiftId());
    }

    @Override
    public long count(SysGiftQuery sysGiftQuery) {
        SysGiftExample sysActiveExample=new SysGiftExample();
        if(sysGiftQuery.getGiftName()!=null&&!sysGiftQuery.getGiftName().equals("")){
            sysActiveExample.createCriteria().andGiftNameEqualTo(sysGiftQuery.getGiftName().trim());
        }
        return sysGiftMapper.countByExample(sysActiveExample);
    }

    @Override
    public Integer UpdateGift(SysGift sysGift) {
        return sysGiftMapper.updateByPrimaryKeySelective(sysGift);
    }
}
