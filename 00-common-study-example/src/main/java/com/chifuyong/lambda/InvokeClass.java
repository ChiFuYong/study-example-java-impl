package com.chifuyong.lambda;

/**
 * 调用类
 *
 * @date： 2020/12/24
 * @author: chify
 */
public class InvokeClass {

    public String invoke(LambdaInterface lambdaInterface){

        String result = lambdaInterface.action("调用类入参！");

        System.out.println("回参:" + result);

        return result;
    }


}
