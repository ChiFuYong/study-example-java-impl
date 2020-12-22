package com.chifuyong.exception;

/**
 * Test类
 *
 * @date： 2020/12/19
 * @author: chify
 */
public class ExceptionTestDemo {

    public static void main(String[] args) throws Exception {
        ExceptionTestDemo test = new ExceptionTestDemo();
        //1.当调用 throws 运行时异常的方法时，不用 try、catch，或者向上 throws 抛出
//        test.testRuntimeException();

        //2.调用检查时异常时，需要 try、catch 或者向上抛异常，否则编译不通过
//        test.testException();

        try {
            //try、catch, 或者向上抛异常
            test.testException();
        }catch (Exception e){
            System.out.println("异常信息为：" + e.getMessage());
            return;
        }finally {
            System.out.println("不管怎样多执行 finally，即使 return 了...");
        }
        System.out.println("catch 后依然执行程序。。。");

        //不 try 、catch 的话，就向上往方法中抛出异常
        test.testException();

    }

    public void testRuntimeException() throws RuntimeException{
        //制造除数不为 0 异常， ArithmeticException extends RuntimeException，运行时异常
        int a = 1/0;
    }

    public void testException() throws Exception{
        //制造一个检查时异常
        throw new Exception("检查时异常！");
    }

}
