package com.chifuyong.a_classloader;

/**
 * 类加载过程：初始化阶段测试
 * 构造方法中指令按语句在源文件中出现的顺序执行
 * @Date: 2020/7/18
 * @author: chify
 */
public class ClassInitTest {

   private static int num = 1;

   static{
       num = 2;
       number = 20;
       System.out.println(num);

       //Illegal forward reference --> 非法的前向引用。
//       System.out.println(number);
   }

    // Linking 阶段之 prepare: number = 0 --> initial: 20 --> 10
   private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);//2
        System.out.println(ClassInitTest.number);//10
    }

    public static void test(){
        //jclasslib 的 Methods main 局部变量表里无 this 变量
        //证明静态函数无法调用成员函数
        int i = 5;
    }

    public void test1(){
        //jclasslib 的 Methods test 局部变量表里有 this 变量
        //证明 this 成员函数里是可以调用其他成员函数
        int i = 5;
    }

}
