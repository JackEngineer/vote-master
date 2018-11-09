package com.cn.ssm.controller;

import com.cn.ssm.dao.SysActive;
import com.cn.ssm.dao.SysPrize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("WeChat")
public class WeChatController {

    @RequestMapping(value = "/addWeChat")
    public @ResponseBody
    Map addPrize(SysPrize sysPrize){
        sysPrize.getPrizeContext();
      return null;
    }

}
