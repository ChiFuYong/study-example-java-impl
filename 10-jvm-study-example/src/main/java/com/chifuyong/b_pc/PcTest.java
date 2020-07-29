package com.chifuyong.b_pc;

/**
 * PC寄存器测试Demo
 *
 * @date： 2020/6/30
 * @author: chify
 */
public class PcTest {

    public static String string= "<clinit> 测试";

    public static void main(String[] args) {
        //jclasslib 的 Methods main 局部变量表里无 this 变量
        //证明静态函数无法调用成员函数
        int i = 5;
    }

    public static void test1(){}

    public void test(){
        //jclasslib 的 Methods test 局部变量表里有 this 变量
        //证明 this 成员函数里是可以调用其他成员函数
        int i = 5;
    }

}
