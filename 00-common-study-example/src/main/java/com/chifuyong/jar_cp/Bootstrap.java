package com.chifuyong.jar_cp;

import jline.ConsoleReader;
import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * Cli 命令行测试 demo
 *
 * @date： 2020/4/16
 * @author: chify
 */
public class Bootstrap {

    public static void main(String[] args) throws ParseException, IOException {
        for (int i = 0;i<args.length;i++){
            System.out.println("args["+i+"] = " + args[i]);
        }
        //测试调用其他类方法
        TestMain.test();

        //定义操作
        Options options = new Options();
        options.addOption("help","help",false,"显示帮助");
        options.addOption("start","start",false,"启动指定进程");
        options.addOption("stop","stop",false,"关闭指定进程");

        //解析阶段
        // 添加 -c 参数，需要输入数值
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args,true);

        //处理阶段
        if(cmd.hasOption("help")) {
            HelpFormatter f = new HelpFormatter();
            f.printHelp("java -cp ..." + Bootstrap.class.getCanonicalName() + " [options]",options);
        }
        if(cmd.hasOption("start")) {
            System.out.println("是否要退出？（Y/N）");
            String read = new ConsoleReader().readLine();
            if ("Y".equalsIgnoreCase(read.trim())){
                System.exit(0);
            }
        }
        if(cmd.hasOption("stop")) {
            System.out.println("使用了 stop 参数...");
        }

        System.out.println(cmd.getOptionValue("start"));


    }

}
