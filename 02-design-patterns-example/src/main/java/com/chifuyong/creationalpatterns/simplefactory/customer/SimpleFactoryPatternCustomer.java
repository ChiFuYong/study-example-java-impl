package com.chifuyong.creationalpatterns.simplefactory.customer;

import com.chifuyong.creationalpatterns.simplefactory.factory.OperationFactory;
import com.chifuyong.creationalpatterns.simplefactory.interfac.Operation;

import java.util.Scanner;

/** 
* 简单工厂模式客户端测试类
* @ClassName SimpleFactoryPatternCustomer 
* @date 2019年10月8日 上午11:02:07 
* @author chify
*/
public class SimpleFactoryPatternCustomer {
	
	public static void main(String[] args) throws Exception {
		System.out.println("请输入第一位数：");
		Scanner sc = new Scanner(System.in);
		String d1 = sc.nextLine();
		System.out.println("请输入需要做的运算(+、-、×、/)：");
		String operationstr = sc.nextLine();
		System.out.println("请输入第二位数：");
		String d2 = sc.nextLine();
		//获取相应的云算类型对象
		Operation operation = OperationFactory.getOperation(operationstr);
		Double result = operation.getResult(Double.valueOf(d1), Double.valueOf(d2));
		System.out.println("运算结果为："+result);
		
	}
}
