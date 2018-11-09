package com.cn.ssm.controller;

import com.cn.ssm.dao.SysUser;
import com.cn.ssm.service.LoginService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.codec.binary.Base64;//依赖包
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


@Controller
public class LoginController {
    private String name=null;
    private String uuid=null;
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/login")
    public @ResponseBody
    Map login(String userName, String userPassword,HttpServletRequest req,HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> result = new HashMap<String, Object>();
        HttpSession session = req.getSession();
        Integer count=loginService.login(userName,userPassword);
        req.setCharacterEncoding("UTF-8");
        if(count>0){
            result.put("errorCode", 0);
            result.put("errorMessage", "执行成功");
            result.put("operationRes", userName+"登录成功！");
            result.put("session",req.getRequestedSessionId());
            name=userName;
            String reqName = userName;
            // 2.将用户名保存在session中
            session.setAttribute("uname", reqName);
        }else{
            result.put("errorCode",9);
            result.put("errorMessage", "登录失败用户不存在");
        }
        return result;
    }

    @RequestMapping(value = "/updatePassword")
    public @ResponseBody
    Map updatePassword(String password,String newPwd){
        Map<String,Object> result = new HashMap<String, Object>();
        SysUser chAnUser=loginService.selectUser(name);
        String userPassword=chAnUser.getUserPassword();
        if(!userPassword.equals(password)){
            result.put("errorCode",9);
            result.put("errorMessage", "旧密码错误");
            return result;
        }else{
          Integer count=loginService.updateUser(newPwd,name);
            if(count>0){
            result.put("errorCode", 0);
            result.put("errorMessage", "执行成功");
            return result;
        }else{
            result.put("errorCode",9);
            result.put("errorMessage","修改失败");
            return result;
            }
        }
    }



    @RequestMapping(value = "/security", method = RequestMethod.GET)
    @ResponseBody
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String code = req.getParameter("code");
        System.out.println("code:"+code);
        //获取code后，请求以下链接获取access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtil.APPID
                + "&secret=" + AuthUtil.APPSECRET
                + "&code=" + code
                + "&grant_type=authorization_code";
        String r = AuthUtil.doGetJson(url);
        HttpSession session = req.getSession();
        String userName="admin";
        session.setAttribute("uname", userName);
        session.setAttribute("r", r);
        Gson gs = new Gson();
        Map<String,String> map = gs.fromJson(r, Map.class);
        String openId=map.get("openid");
        String base="openId="+openId+"#uuid="+this.uuid;
        byte[] bt = base.getBytes();
        String newKey=(new BASE64Encoder()).encodeBuffer(bt);
        response.sendRedirect("http://47.100.243.198:8080/vote-system/#/index/"+newKey);
    }

    @RequestMapping(value = "/wxlogin", method = RequestMethod.GET)
    @ResponseBody
    public void wxlogin(HttpServletRequest request, HttpServletResponse response,String uuid) throws IOException {
        //第一步：引导用户进入授权页面同意授权，获取code
        String backUrl = "http://4d1f1de0.ngrok.io/master/security";
        //授权页面地址
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID
                + "&redirect_uri="+ URLEncoder.encode(backUrl)
                + "&response_type=code"
                + "&scope=snsapi_userinfo"
                + "&state=STATE#wechat_redirect";
        //重定向到授权页面
        this.uuid=uuid;
        response.sendRedirect(url);
    }

}
