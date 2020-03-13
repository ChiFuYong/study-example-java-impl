package com.chifuyong.behavioralpatterns.strategy.customer;

import com.chifuyong.behavioralpatterns.strategy.context.CaculateAmountContext;
import com.chifuyong.behavioralpatterns.strategy.context.combinesimplefactory.CaculateAmountCombineSimpleFactoryContext;
import com.chifuyong.behavioralpatterns.strategy.context.enums.RepayMethod;
import com.chifuyong.behavioralpatterns.strategy.impl.*;

public class StrategyPatternCustomer {
	
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
		CaculateAmountCombineSimpleFactoryContext factroyContext1 = new CaculateAmountCombineSimpleFactoryContext(RepayMethod.OT.getDesc());
		factroyContext1.calculateInterest();
		CaculateAmountCombineSimpleFactoryContext factroyContext2 = new CaculateAmountCombineSimpleFactoryContext(RepayMethod.EP.getDesc());
		factroyContext2.calculateInterest();
		CaculateAmountCombineSimpleFactoryContext factroyContext3 = new CaculateAmountCombineSimpleFactoryContext(RepayMethod.EI.getDesc());
		factroyContext3.calculateInterest();
		CaculateAmountCombineSimpleFactoryContext factroyContext4 = new CaculateAmountCombineSimpleFactoryContext(RepayMethod.WL.getDesc());
		factroyContext4.calculateInterest();
		CaculateAmountCombineSimpleFactoryContext factroyContext5 = new CaculateAmountCombineSimpleFactoryContext(RepayMethod.SG.getDesc());
		factroyContext5.calculateInterest();
		CaculateAmountCombineSimpleFactoryContext factroyContext6 = new CaculateAmountCombineSimpleFactoryContext(RepayMethod.PI.getDesc());
		factroyContext6.calculateInterest();
	}
}
