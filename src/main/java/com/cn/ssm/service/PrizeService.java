package com.cn.ssm.service;

import com.cn.ssm.dao.SysPrize;
import com.cn.ssm.dao.SysPrizeQuery;

import java.util.List;

/**
 * Created by admin on 2018/8/26.
 */
public interface PrizeService {
    Integer AddPrize(SysPrize sysPrize);
    List<SysPrize> list(SysPrizeQuery sysPrizeQuery);
    long count(SysPrizeQuery sysPrizeQuery);
    Integer deletePrize(SysPrize sysPrize);
    Integer UpdatePrize(SysPrize sysPrize);
}
