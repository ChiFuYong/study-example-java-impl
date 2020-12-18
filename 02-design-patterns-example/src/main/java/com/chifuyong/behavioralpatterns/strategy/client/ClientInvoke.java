package com.chifuyong.behavioralpatterns.strategy.client;

import com.chifuyong.behavioralpatterns.strategy.context.CaculateAmountContext;
import com.chifuyong.behavioralpatterns.strategy.context.combinesimplefactory.CaculateAmountCombineSimpleFactoryContext;
import com.chifuyong.behavioralpatterns.strategy.context.enums.RepayMethod;
import com.chifuyong.behavioralpatterns.strategy.impl.*;

/**
 * 客户端测试类
 *
 * @Date: 2020/4/14
 * @author: chify
 */
public class ClientInvoke {
	
	public static void main(String[] args) {
		//策略模式
		CaculateAmountContext context1 = new CaculateAmountContext(new YiCiXingHuanBenFuXiStrategy());
		context1.calculateInterest();
		CaculateAmountContext context2 = new CaculateAmountContext(new DengEBenJinStrategy());
		context2.calculateInterest();
		CaculateAmountContext context3 = new CaculateAmountContext(new DengEBenXiStrategy());
		context3.calculateInterest();
		CaculateAmountContext context4 = new CaculateAmountContext(new SuiJieSuiHuanStrategy());
		context4.calculateInterest();
		CaculateAmountContext context5 = new CaculateAmountContext(new FenQiHuanBenStrategy());
		context5.calculateInterest();
		CaculateAmountContext context6 = new CaculateAmountContext(new XianXiHouBenStrategy());
		context6.calculateInterest();
		
		System.out.println();
		System.out.println("------------分割线------------");
		System.out.println();
		
		//结合简单工厂使用策略模式
		// 假设这里的 RepayMethod 是数据库里查到的不同的值，这样 Context 就让 Strategy 和客户端调用类解耦合了
		CaculateAmountCombineSimpleFactoryContext factroyContext1 =
				new CaculateAmountCombineSimpleFactoryContext(RepayMethod.PI);
		factroyContext1.calculateInterest();

	}
}
