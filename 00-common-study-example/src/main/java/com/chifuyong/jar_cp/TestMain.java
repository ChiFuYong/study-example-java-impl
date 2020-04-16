package com.chifuyong.jar_cp;

/**
 * 可执行 jar 主函数（测试 java -cp 命令使用）
 *
 * @date： 2020/4/16
 * @author: chify
 */
public class TestMain {

    public static void main(String[] args) {
        for (int i = 0;i<args.length;i++){
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }

    public static void test(){
        System.out.println();
        System.out.println("进入 TestMain.test()....");
        System.out.println();
    }


}
