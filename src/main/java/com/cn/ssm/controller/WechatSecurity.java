//package com.cn.ssm.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.URLEncoder;
//import java.util.Map;
//import org.apache.log4j.Logger;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class WechatSecurity {
//    private static Logger logger = Logger.getLogger(WechatSecurity.class);
//
//    /**
//     * ngrok http 80 ngrok启动方法
//     * @Description: 用于接收 get 参数，返回验证参数
//     * @param @param request
//     * @param @param response
//     * @param @param signature
//     * @param @param timestamp
//     * @param @param nonce
//     * @param @param echostr
//     * @author dapengniao
//     * @date 2016 年 3 月 4 日 下午 6:20:00
//     */
//    @RequestMapping(value = "/security", method = RequestMethod.GET)
//    @ResponseBody
//    public void doGet(
//            HttpServletRequest req,
//            HttpServletResponse response
////            @RequestParam(value = "signature", required = true) String signature,
////            @RequestParam(value = "timestamp", required = true) String timestamp,
////            @RequestParam(value = "nonce", required = true) String nonce,
////            @RequestParam(value = "echostr", required = true) String echostr
//    ) throws IOException, ServletException {
//        String code = req.getParameter("code");
//        System.out.println("code:"+code);
//        //获取code后，请求以下链接获取access_token
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtil.APPID
//                + "&secret=" + AuthUtil.APPSECRET
//                + "&code=" + code
//                + "&grant_type=authorization_code";
//
//        //通过网络请求方法来请求上面这个接口
//        String r = AuthUtil.doGetJson(url);
//        HttpSession session = req.getSession();
//        session.setAttribute("r", r);
//    }
//
//
//    @RequestMapping(value = "/wxlogin", method = RequestMethod.GET)
//    public void wxlogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //第一步：引导用户进入授权页面同意授权，获取code
//        String backUrl = "http://61459903.ngrok.io/master/security";
//        //授权页面地址
//        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID
//                + "&redirect_uri="+ URLEncoder.encode(backUrl)
//                + "&response_type=code"
//                + "&scope=snsapi_userinfo"
//                + "&state=STATE#wechat_redirect";
//
//        //重定向到授权页面
//        response.sendRedirect(url);
//    }
//
//
//}