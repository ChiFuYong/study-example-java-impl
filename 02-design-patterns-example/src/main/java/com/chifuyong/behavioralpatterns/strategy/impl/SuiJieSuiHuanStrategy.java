package com.chifuyong.behavioralpatterns.strategy.impl;

import com.chifuyong.behavioralpatterns.strategy.api.Strategy;

import java.math.BigDecimal;

/** 
* 随借随还
* @date 2019年10月17日 下午1:50:48
* @author chify
*/
public class SuiJieSuiHuanStrategy implements Strategy{

	@Override
	public BigDecimal caculateInterest() {
		System.out.println("随借随还计算利息");
		return BigDecimal.ZERO;
	}

}
