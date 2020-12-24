package com.chifuyong.lambda;

import com.chifuyong.reflect.Hello;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * lambda表达式使用
 *
 * @date： 2020/12/24
 * @author: chify
 */
public class LambdaDemo {

    /**
     * 使用 Thread 和 Runnable 测试 lambda 表达式
     * */
    @Test
    public void test(){
        System.out.println("I am " + Thread.currentThread().getName() + " thread!");

        //1.匿名内部类写法
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 这是一个匿名内部类写法");
            }
        };
        Class<? extends Runnable> runnable1Class = runnable1.getClass();
        System.out.println("这是一个匿名内部类，类名为：" + runnable1Class.getName());
        Thread thread1 = new Thread(runnable1);
        thread1.start();
        System.out.println();

        //2.lambda 表达式写法
        Runnable runnable2 = () ->{
            System.out.println(Thread.currentThread().getName() + " 这是一个 lambda 表达式写法");
        };
        Class<? extends Runnable> runnable2Class = runnable2.getClass();
        System.out.println("lambda 表达式生成的类，类名为：" + runnable2Class.getName());
        Thread thread2 = new Thread(runnable2);
        thread2.start();
        System.out.println();

        //3. lambda 表达式真正写法
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "lambda真正的使用方式！");
        }).start();

    }

    /**
     * 自定义接口测试 lambda 表达式
     */
    @Test
    public void test2(){
        //1.使用 lambda 表达式生成了一个匿名内部类对象 lambdaInterface
        LambdaInterface lambdaInterface = (a) -> {
            System.out.println("入参为：" + a);
            String str = "return result";
            return str;
        };
        Class<? extends LambdaInterface> lambdaInterfaceClass = lambdaInterface.getClass();
        Class<?>[] interfaces = lambdaInterfaceClass.getInterfaces();
        System.out.println("lambda 接口名为： " + interfaces[0].getName());
        System.out.println("lambda 表达式生成的类，类名为：" + lambdaInterfaceClass.getName());
        //可以直接使用匿名内部类对象调用接口中 action 方法
        String b = "Hello Lambda expression ！";
        String action = lambdaInterface.action(b);
        System.out.println("回参" + action);
        //也可以调用接口中 default 方法
        lambdaInterface.action2();
        System.out.println();

        //2.lambda 表达式的真正的使用方式
        InvokeClass invokeClass = new InvokeClass();
        String result = invokeClass.invoke((a) -> {
            System.out.println("入参为：" + a);
            return getString();
        });

    }

    public String getString(){
        return "lambda 回参";
    }

}
