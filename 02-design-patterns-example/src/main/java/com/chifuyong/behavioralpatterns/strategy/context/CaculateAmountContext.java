package com.chifuyong.behavioralpatterns.strategy.context;

import com.chifuyong.behavioralpatterns.strategy.interfac.Strategy;

import java.math.BigDecimal;

/** 
* 策略模式：金额计算上下文
* @ClassName CaculateAmountContext 
* @date 2019年10月17日 下午1:53:11 
* @author chify
*/
public class CaculateAmountContext {
	
	private Strategy strategy;

	public CaculateAmountContext(Strategy strategy) {
		super();
		this.strategy = strategy;
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
