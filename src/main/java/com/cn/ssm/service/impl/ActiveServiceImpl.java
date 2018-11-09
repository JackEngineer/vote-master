package com.cn.ssm.service.impl;

import com.cn.ssm.dao.*;
import com.cn.ssm.mapping.SysActiveMapper;
import com.cn.ssm.mapping.SysImgMapper;
import com.cn.ssm.mapping.SysWatchMapper;
import com.cn.ssm.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ActiveServiceImpl implements ActiveService {
    @Autowired
    private SysActiveMapper sysActiveMapper;
    @Autowired
    private SysWatchMapper sysWatchMapper;
    @Autowired
    private SysImgMapper sysImgMapper;

    public Integer getId(String activeName){
        SysActiveExample sysActiveExample=new SysActiveExample();
        sysActiveExample.createCriteria().andActiveNameEqualTo(activeName);
        return sysActiveMapper.selectByExample(sysActiveExample).get(0).getActiveId();
    }

    public String getName(Integer activeId){
        SysActiveExample sysActiveExample=new SysActiveExample();
        sysActiveExample.createCriteria().andActiveIdEqualTo(activeId);
        return sysActiveMapper.selectByExample(sysActiveExample).get(0).getActiveName();
    }

    @Override
    public Integer AddActive(SysActive sysActive) {
        String uuid = UUID.randomUUID().toString();
        sysActive.setActiveUuid(uuid);
        sysActive.setActiveUrl("http://www.hzrtpxt.top/master/wxlogin?uuid="+uuid);
        Integer result=sysActiveMapper.insert(sysActive);
        SysActiveQuery sysActiveQuery = new SysActiveQuery();
        List<SysActive> sysActiveList=this.list(sysActiveQuery);
        Integer id=sysActiveList.get(sysActiveList.size()-1).getActiveId();
        SysWatch sysWatch=new SysWatch();
        sysWatch.setWatchActiveid(id);
        sysWatch.setWatchNumb(0);
        sysWatchMapper.insert(sysWatch);
        return result;
    }

    @Override
    public List<SysActive> list(SysActiveQuery sysActiveQuery) {
        SysActiveExample sysActiveExample=new SysActiveExample();
        if(sysActiveQuery.getActiveName()!=null&&!sysActiveQuery.getActiveName().equals("")){
            sysActiveExample.createCriteria().andActiveNameEqualTo(sysActiveQuery.getActiveName().trim());
        }
        sysActiveExample.setOrderByClause(" active_id limit "+(sysActiveQuery.getPage()-1)*sysActiveQuery.getRows()+","+sysActiveQuery.getRows());
        return sysActiveMapper.selectByExample(sysActiveExample);
    }

    @Override
    public Integer deleteActive(SysActiveQuery sysActiveQuery) {
        return sysActiveMapper.deleteByPrimaryKey(sysActiveQuery.getActiveId());
    }

    @Override
    public Integer deleteActiveImg(SysImgQuery sysImgQuery) {
        return sysImgMapper.deleteByPrimaryKey(sysImgQuery.getImgId());
    }

    @Override
    public Integer count(SysActiveQuery sysActiveQuery) {
        SysActiveExample sysActiveExample=new SysActiveExample();
        if(sysActiveQuery.getActiveName()!=null&&!sysActiveQuery.getActiveName().equals("")){
            sysActiveExample.createCriteria().andActiveNameEqualTo(sysActiveQuery.getActiveName().trim());
        }
        return sysActiveMapper.countByExample(sysActiveExample);
    }

    @Override
    public Integer UpdateActive(SysActiveQuery sysActiveQuery) {
        return sysActiveMapper.updateByPrimaryKeySelective(sysActiveQuery);
    }

    @Override
    public List<SysImgQuery> sysImgLit(SysImgQuery sysImgQuery) {
        List<SysImgQuery> sysImgQueries=new ArrayList<SysImgQuery>();
        SysImgExample sysImgExample=new SysImgExample();
        if(sysImgQuery.getActiveName()!=null) {
            Integer id = getId(sysImgQuery.getActiveName());
            sysImgExample.createCriteria().andImgParentidEqualTo(id).andImgTypeEqualTo(1);
        }else{
            sysImgExample.createCriteria().andImgTypeEqualTo(1);
        }
       List<SysImg> sysImgs=sysImgMapper.selectByExample(sysImgExample);
        for(int i=0;i<sysImgs.size();i++){
            SysImgQuery sysImgQuery1=new SysImgQuery();
            String name=getName(sysImgs.get(i).getImgParentid());
            sysImgQuery1.setActiveName(name);
            sysImgQuery1.setImgSource(sysImgs.get(i).getImgSource());
            sysImgQuery1.setImgId(sysImgs.get(i).getImgId());
            sysImgQueries.add(sysImgQuery1);
        }
        return sysImgQueries;
    }

    @Override
    public Long countImg(SysImgQuery sysImgQuery) {
        SysImgExample sysImgExample=new SysImgExample();
        if(sysImgQuery.getActiveName()!=null&&!sysImgQuery.getActiveName().equals("")){
            Integer id = getId(sysImgQuery.getActiveName());
            sysImgExample.createCriteria().andImgParentidEqualTo(id).andImgTypeEqualTo(1);
        }else{
            sysImgExample.createCriteria().andImgTypeEqualTo(1);
        }
        return sysImgMapper.countByExample(sysImgExample);
    }
}
