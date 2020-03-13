package com.chifuyong.behavioralpatterns.strategy.interfac;

import java.math.BigDecimal;

/** 
* 策略接口：金额计算
* @ClassName Strategy 
* @date 2019年10月17日 下午1:42:51 
* @author chify
*/

public interface Strategy {
	
	/** 
	 * caculateInterest: 计算利息 <br/>  
	 * @author chify
	 * @return 返回利息
	 * @since JDK 1.8
	 */
	public BigDecimal caculateInterest();

}
