package com.cn.ssm.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by admin on 2018/9/16.
 */
public class AuthUtil {
    public static final String APPID = "wx339df95d83b73048";
    public static final String APPSECRET = "17b7e52222e27ef56227aaa4cf5c1438";

    public static String doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = defaultHttpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        if (httpEntity != null) {
            String result = EntityUtils.toString(httpEntity, "UTF-8");
            return result;
        }else{
            return null;
        }
    }
}