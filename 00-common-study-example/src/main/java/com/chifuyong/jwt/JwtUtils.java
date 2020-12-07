package com.chifuyong.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 工具类
 *
 * @date： 2020/11/23
 * @author: chify
 */
public class JwtUtils {

    private static final String SING = "P@ssW0rd";

    private static final Algorithm algorithm = Algorithm.HMAC256(SING);

    /**
     * 获取 Token, 过期时间（7天）
     * @param infoMap 验证信息
     * @return
     */
    public static String getToken(Map<String,String> infoMap) {
        return getToken(infoMap,null);
    }

    /**
     * 获取 Token
     * @param infoMap 验证信息
     * @param calendar 过期时间
     * @return
     */
    public static String getToken(Map<String,String> infoMap,Calendar calendar){
        //1.建造模式获取 Builder 对象
        JWTCreator.Builder builder = JWT.create();
        infoMap.forEach((k,v) ->{
            builder.withClaim(k, v);
        });
        if (null == calendar){
            //设置默认过期时间为 7 天
            calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE,7);
        }
        //2.设置过期时间
        builder.withExpiresAt(calendar.getTime());
        //3.数字签名加密获取 Token
        String token = builder.sign(algorithm);
        return token;
    }


    /**
     * 验证 Token 合法性，并返回 DecodedJWT 对象
     * @param token token string
     * @return
     */
    public static DecodedJWT verifyToken(String token){
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT verify = jwtVerifier.verify(token);
//        String name = decodedJWT.getClaim("name").asString();
//        Date expiresAt = decodedJWT.getExpiresAt();
        return verify;
    }

}
