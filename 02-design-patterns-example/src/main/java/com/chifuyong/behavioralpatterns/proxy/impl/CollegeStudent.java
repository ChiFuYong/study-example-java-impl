package com.chifuyong.behavioralpatterns.proxy.impl;

import com.chifuyong.behavioralpatterns.proxy.api.Person;

/**
 * 需要出国的大学生（被代理类）
 *
 * @date： 2020/12/17
 * @author: chify
 */
public class CollegeStudent implements Person {

    @Override
    public String applyToAbroad() {
        System.out.println("拿到代理人提供的各种手续证明，开始签字ing...");
        return "success";
    }
}
