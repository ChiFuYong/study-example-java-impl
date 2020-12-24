package com.chifuyong.lambda;

/**
 * Lambda测试接口
 *
 * @date： 2020/12/24
 * @author: chify
 */
@FunctionalInterface
public interface LambdaInterface {

    public String action(String str);

    default void action2(){
        System.out.println("I am interface‘s dafault method !");
    }
}
