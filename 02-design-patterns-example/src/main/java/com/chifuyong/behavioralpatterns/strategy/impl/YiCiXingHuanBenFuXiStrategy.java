package com.chifuyong.behavioralpatterns.strategy.impl;

import com.chifuyong.behavioralpatterns.strategy.interfac.Strategy;

import java.math.BigDecimal;

/** 
* 一次性还本付息
* @ClassName YiCiXingHuanBenFuXiStrategy 
* @date 2019年10月17日 下午1:44:48 
* @author chify
*/
public class YiCiXingHuanBenFuXiStrategy implements Strategy {

	@Override
	public BigDecimal caculateInterest() {
		System.out.println("一次性还本付息计算利息");
		return BigDecimal.ZERO;
	}

}
