package com.chifuyong.jwt.springboot.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chifuyong.jwt.JwtUtils;
import com.chifuyong.jwt.springboot.utils.ResponseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * JWT 拦截器
 *
 * @date： 2020/12/7
 * @author: chify
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //前端中将 token 放入 Header 里
        String token = request.getHeader("token");
        Map<String,Object> responseMap;
        try {
            DecodedJWT decodedJWT = JwtUtils.verifyToken(token);
            //验证成功，放行
            return true;
        }catch (SignatureVerificationException e){
            //无效签名
            responseMap = ResponseUtils.getResponse(false,e.getMessage());
            e.printStackTrace();
        }catch (TokenExpiredException e){
            //token 过期
            responseMap = ResponseUtils.getResponse(false,e.getMessage());
            e.printStackTrace();
        }catch (AlgorithmMismatchException e){
            //token 算法不一致
            responseMap = ResponseUtils.getResponse(false,e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            //token 无效
            responseMap = ResponseUtils.getResponse(false,e.getMessage());
            e.printStackTrace();
        }
        //返回验证失败信息
        String resopnseJson = new ObjectMapper().writeValueAsString(responseMap);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(resopnseJson);
        return false;
    }
}
