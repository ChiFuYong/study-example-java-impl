package com.chifuyong.jwt;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chifuyong.jwt.springboot.utils.ResponseUtils;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtTest
 *
 * @date： 2020/12/7
 * @author: chify
 */
public class JwtTest {

    @Test
    public void testGetToke() {
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put("name", "chify");
        infoMap.put("passwd", "0607");
        //获取 Token
        String token = JwtUtils.getToken(infoMap);
        System.out.println("Token is :" + token);
    }

    @Test
    public void testVerifyToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd2QiOiIwNjA3IiwibmFtZSI6ImNoaWZ5IiwiZXhwIjoxNjA3OTEyMTM3fQ" +
                ".FWaJdJ8_asyCJWb4jBlKSsUqicrAjrpBemMc3UA7bIk";
        try {
            //验证 Token
            DecodedJWT verify = JwtUtils.verifyToken(token);
            String aftetVerifyToken = verify.getToken();
            System.out.println("Token is :" + aftetVerifyToken);

            String name = verify.getClaim("name").asString();
            System.out.println("Name is : " + name);

            String passwd = verify.getClaim("passwd").asString();
            System.out.println("Passwd is : " + passwd);

            Date expiresAt = verify.getExpiresAt();
            System.out.println("Expire date is : " + expiresAt);
        }catch(SignatureVerificationException e) {
            //无效签名
            e.printStackTrace();
        }catch(TokenExpiredException e) {
            //token 过期
            e.printStackTrace();
        }catch(AlgorithmMismatchException e) {
            //token 算法不一致
            e.printStackTrace();
        }catch(Exception e) {
            //token 无效
            e.printStackTrace();
        }
    }

}
