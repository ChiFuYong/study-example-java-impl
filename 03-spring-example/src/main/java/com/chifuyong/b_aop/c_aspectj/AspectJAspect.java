package com.chifuyong.b_aop.c_aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Auther: chify
 * @Date: 01/03/2020 16:32
 * @Description: AspectJ 切面类
 */
@Component
@Aspect
public class AspectJAspect {

    @Pointcut("execution(* com.chifuyong.b_aop.TestServiceImpl.*(..))")
    private void piontCut(){}

//    @Before("execution(* com.chifuyong.aop.TestServiceImpl.*(..))")
    @Before(value = "piontCut()")
    public void before(JoinPoint joinpoint){
        System.out.println("前置通知：" + joinpoint.getSignature().getName());
    }

//  @AfterReturning(value = "execution(* com.chifuyong.aop.TestServiceImpl.*(..))",returning = "ret")
    @AfterReturning(value = "piontCut()",returning = "ret")
    public void afterReturning(JoinPoint joinpoint,Object ret){
        System.out.println("后置通知：" + joinpoint.getSignature().getName() + " , -->" + ret);
    }

    @Around(value = "piontCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("执行前...");
        //执行目标方法
        Object obj = joinPoint.proceed();
        System.out.println("执行后...");
        return obj;
    }

    @AfterThrowing(value = "execution(* com.chifuyong.b_aop.TestServiceImpl.*(..))",throwing = "e")
    public void afterThrowing(JoinPoint joinpoint,Throwable e){
        System.out.println("抛出异常通知:" + e.getMessage());
    }

    @After("piontCut()")
    public void after(JoinPoint joinpoint){
        System.out.println("最终通知");
    }
}
