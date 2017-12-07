package com.signs.util;

import com.alibaba.fastjson.JSON;
import com.signs.model.commons.SmsSendRequest;
import com.signs.model.commons.SmsSendResponse;

import java.util.UUID;

/**
  * Description : 通用工具类
  **/
public class CommonUtils {



    /*
    *  获取uuid
    * */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /*
    * 发送短信
    * @Param   phone   手机号
    * @Param   msg     短信内容
    * */
    public static boolean sendSms(String phone,String msg){

        final String charset = "utf-8";
        // 用户平台API账号(非登录账号,示例:N1234567)
        final String account = "N4105432";
        // 用户平台API密码(非登录密码)
        String pswd = "6405139d";


        // 向手机发送短信
        // 请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
        String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";

        // 状态报告
        String report= "true";

        SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);

        String requestJson = JSON.toJSONString(smsSingleRequest);

        System.out.println("before request string is: " + requestJson);

        String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

        System.out.println("response after request result is :" + response);

        SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

        System.out.println("response  toString is :" + smsSingleResponse);

        return true;
    }


}
