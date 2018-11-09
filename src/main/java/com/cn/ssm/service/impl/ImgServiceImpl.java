package com.cn.ssm.service.impl;

import com.cn.ssm.dao.SysImg;
import com.cn.ssm.dao.SysImgExample;
import com.cn.ssm.mapping.SysImgMapper;
import com.cn.ssm.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    SysImgMapper sysImgMapper;
    @Override
    public Integer AddImg(SysImg sysImg) {
        return sysImgMapper.insert(sysImg);
    }

    @Override
    public SysImg getImgUrl(SysImg sysImg) {
        SysImgExample sysImgExample=new SysImgExample();
        sysImgExample.createCriteria().andImgTypeEqualTo(sysImg.getImgType()).andImgParentidEqualTo(sysImg.getImgParentid());
        sysImgExample.setOrderByClause("img_id DESC");
        List<SysImg> sysImgList=sysImgMapper.selectByExample(sysImgExample);
        if(sysImgList.size()>0){
            return sysImgList.get(0);
        }
        return null;
    }
}
