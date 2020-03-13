package com.chifuyong.behavioralpatterns.strategy.impl;

import com.chifuyong.behavioralpatterns.strategy.interfac.Strategy;

import java.math.BigDecimal;

/** 
* 等额本息
* @ClassName DengEBenXiStrategy 
* @date 2019年10月17日 下午1:44:59 
* @author chify
*/
public class DengEBenXiStrategy implements Strategy {

	@Override
	public BigDecimal caculateInterest() {
		System.out.println("等额本息计算利息");
		return BigDecimal.ZERO;
	}

}
