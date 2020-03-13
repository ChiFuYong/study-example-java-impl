package com.chifuyong.behavioralpatterns.strategy.context.combinesimplefactory;

import com.chifuyong.behavioralpatterns.strategy.impl.*;
import com.chifuyong.behavioralpatterns.strategy.interfac.Strategy;

import java.math.BigDecimal;

/** 
* 策略模式（结合简单工厂模式）：金额计算上下文
* @ClassName CaculateAmountContext 
* @date 2019年10月17日 下午1:53:11 
* @author chify
*/
public class CaculateAmountCombineSimpleFactoryContext {
	
	private Strategy strategy;

	/** 
	 * 构造方法：CaculateAmountContext. 采用简单工厂的方式来创建策略对象
	 * @param str 
	 */ 
	public CaculateAmountCombineSimpleFactoryContext(String str) {
		switch (str) {
		case "等额本息": strategy = new DengEBenXiStrategy();
			break;
		case "等额本金": strategy = new DengEBenJinStrategy();
			break;
		case "先息后本": strategy = new XianXiHouBenStrategy();
			break;
		case "分期还本": strategy = new FenQiHuanBenStrategy();
			break;
		case "一次性还本付息": strategy = new YiCiXingHuanBenFuXiStrategy();
			break;
		case "随借随还": strategy = new SuiJieSuiHuanStrategy();
			break;
		default: 
			break;
		}
		
	}
	
	/** 
	 * calculateInterest: 计算利息 <br/>  
	 * @author chify
	 * @return 利息
	 * @since JDK 1.8
	 */
	public BigDecimal calculateInterest() {
		return strategy.caculateInterest();
	}
	
}
