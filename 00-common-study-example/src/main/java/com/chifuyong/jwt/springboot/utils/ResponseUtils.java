package com.chifuyong.jwt.springboot.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应拼装工具类
 *
 * @date： 2020/12/7
 * @author: chify
 */
public class ResponseUtils {

    public static Map<String, Object> getResponse(Boolean status, String message){
        return getResponse(status,message,null);
    }

    public static Map<String, Object> getResponse(Boolean status, String message, String token){
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("status",status);
        responseMap.put("message",message);
        if (null != token){
            responseMap.put("token",token);
        }
        return responseMap;
    }

}
