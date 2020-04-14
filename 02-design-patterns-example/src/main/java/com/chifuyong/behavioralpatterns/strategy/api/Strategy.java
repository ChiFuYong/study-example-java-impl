package com.chifuyong.behavioralpatterns.strategy.api;

import java.math.BigDecimal;

/** 
* 策略接口：金额计算
* @date 2019年10月17日 下午1:42:51
* @author chify
*/
public interface Strategy {
	
	/** 
	 * caculateInterest: 计算利息 <br/>  
	 * @return 返回利息
	 */
	public BigDecimal caculateInterest();

}
