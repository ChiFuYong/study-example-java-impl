package com.chifuyong.behavioralpatterns.strategy.context.combinesimplefactory;

import com.chifuyong.behavioralpatterns.strategy.api.Strategy;
import com.chifuyong.behavioralpatterns.strategy.context.enums.RepayMethod;
import com.chifuyong.behavioralpatterns.strategy.impl.*;

import java.math.BigDecimal;

/** 
* 策略模式（结合简单工厂模式）：金额计算上下文
* @date 2019年10月17日 下午1:53:11
* @author chify
*/
public class CaculateAmountCombineSimpleFactoryContext {
	
	private Strategy strategy;

	/** 
	 * 构造方法：CaculateAmountContext. 采用简单工厂的方式来创建策略对象
	 * @param repayMethod 还款方式
	 */ 
	public CaculateAmountCombineSimpleFactoryContext(RepayMethod repayMethod) {
		switch (repayMethod) {
		case EI: strategy = new DengEBenXiStrategy();
			break;
		case EP: strategy = new DengEBenJinStrategy();
			break;
		case PI: strategy = new XianXiHouBenStrategy();
			break;
		case OT: strategy = new FenQiHuanBenStrategy();
			break;
		case SG: strategy = new YiCiXingHuanBenFuXiStrategy();
			break;
		case WL: strategy = new SuiJieSuiHuanStrategy();
			break;
		default: 
			break;
		}
		
	}
	
	/** 
	 * calculateInterest: 计算利息 <br/>  
	 * @return 利息
	 */
	public BigDecimal calculateInterest() {
		return strategy.caculateInterest();
	}
	
}
