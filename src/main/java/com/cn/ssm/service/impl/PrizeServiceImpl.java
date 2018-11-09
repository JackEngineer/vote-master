package com.cn.ssm.service.impl;

import com.cn.ssm.dao.SysPrize;
import com.cn.ssm.dao.SysPrizeExample;
import com.cn.ssm.dao.SysPrizeQuery;
import com.cn.ssm.mapping.SysPrizeMapper;
import com.cn.ssm.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/8/26.
 */
@Service
public class PrizeServiceImpl implements PrizeService{
    @Autowired
    private SysPrizeMapper sysPrizeMapper;

    @Override
    public Integer AddPrize(SysPrize sysPrize) {
        return sysPrizeMapper.insert(sysPrize);
    }

    @Override
    public List<SysPrize> list(SysPrizeQuery sysPrizeQuery) {
        SysPrizeExample sysPrizeExample=new SysPrizeExample();
        if(sysPrizeQuery.getPrizeName()!=null&&!sysPrizeQuery.getPrizeName().equals("")){
            sysPrizeExample.createCriteria().andPrizeNameEqualTo(sysPrizeQuery.getPrizeName().trim());
        }
        sysPrizeExample.setOrderByClause(" prize_id limit "+(sysPrizeQuery.getPage()-1)*sysPrizeQuery.getRows()+","+sysPrizeQuery.getRows());
        return sysPrizeMapper.selectByExample(sysPrizeExample);
    }

    @Override
    public long count(SysPrizeQuery sysPrizeQuery) {
        SysPrizeExample sysPrizeExample=new SysPrizeExample();
        if(sysPrizeQuery.getPrizeName()!=null&&!sysPrizeQuery.getPrizeName().equals("")){
            sysPrizeExample.createCriteria().andPrizeNameEqualTo(sysPrizeQuery.getPrizeName().trim());
        }
        return sysPrizeMapper.countByExample(sysPrizeExample);
    }

    @Override
    public Integer deletePrize(SysPrize sysPrize) {
        return sysPrizeMapper.deleteByPrimaryKey(sysPrize.getPrizeId());
    }

    @Override
    public Integer UpdatePrize(SysPrize sysPrize) {
        return sysPrizeMapper.updateByPrimaryKeySelective(sysPrize);
    }
}
