package com.chifuyong.behavioralpatterns.proxy.client;

import com.chifuyong.behavioralpatterns.proxy.api.Person;
import com.chifuyong.behavioralpatterns.proxy.impl.MediumProxy;

/**
 * 客户端调用模拟
 *
 * @date： 2020/12/17
 * @author: chify
 */
public class ClientInvoke {

    public static void main(String[] args) {
        Person mediumProxy = new MediumProxy();
        //办理出国
        mediumProxy.applyToAbroad();
    }

}
