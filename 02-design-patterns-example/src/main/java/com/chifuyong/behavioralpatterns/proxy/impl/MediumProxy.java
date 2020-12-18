package com.chifuyong.behavioralpatterns.proxy.impl;

import com.chifuyong.behavioralpatterns.proxy.api.Person;

/**
 * 办理出国的中介代理
 *
 * @date： 2020/12/17
 * @author: chify
 */
public class MediumProxy implements Person {

    private Person abroadPerson = new CollegeStudent();

    @Override
    public String applyToAbroad() {
        System.out.println("为客户获取各种需要的出国资料、跑腿等。。。");

        abroadPerson.applyToAbroad();

        System.out.println("帮忙处理之后的流程，并收取费用，处理完成通知客户，然后收尾款。。。");
        return "success";
    }
}
