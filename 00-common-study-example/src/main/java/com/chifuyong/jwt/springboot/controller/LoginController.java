package com.chifuyong.jwt.springboot.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chifuyong.jwt.JwtUtils;
import com.chifuyong.jwt.springboot.utils.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Login controller
 *
 * @date： 2020/12/7
 * @author: chify
 */
@RestController
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(String name,String passwd){
        Map <String,Object> response ;
        try {
            //假设 queryName、queryPasswd 是从数据库中查出来的。
            String queryName = "chify";
            String queryPasswd = "0607";
            if (queryName.equals(name) && queryPasswd.equals(passwd)){
                Map<String,String> infoMap = new HashMap<>();
                infoMap.put("name",name);
                infoMap.put("passwd",passwd);
                String token = JwtUtils.getToken(infoMap);
                response = ResponseUtils.getResponse(true,"认证成功",token);
            }else {
                response = ResponseUtils.getResponse(false,"用户名或密码不正确！");
            }
        }catch (Exception e){
            response = ResponseUtils.getResponse(false,e.getMessage());
        }
        return response;
    }

    @PostMapping("/verify")
    public Map<String,Object> verify(String token){
        System.out.println("当前 Token " + token);
        Map <String,Object> response;
        try {
            DecodedJWT decodedJWT = JwtUtils.verifyToken(token);
            response = ResponseUtils.getResponse(true,"认证成功！");
        }catch (SignatureVerificationException e){
            //无效签名
            response = ResponseUtils.getResponse(false,e.getMessage());
            e.printStackTrace();
        }catch (TokenExpiredException e){
            //token 过期
            response = ResponseUtils.getResponse(false,e.getMessage());
            e.printStackTrace();
        }catch (AlgorithmMismatchException e){
            //token 算法不一致
            response = ResponseUtils.getResponse(false,e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            //token 无效
            response = ResponseUtils.getResponse(false,e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/hello")
    public Map<String,Object> hello(){
        Map <String,Object> response = new HashMap<>();
        response.put("Hello World!","你好，世界！");
        return response;
    }

}
