package com.chifuyong.behavioralpatterns.strategy.impl;

import com.chifuyong.behavioralpatterns.strategy.interfac.Strategy;

import java.math.BigDecimal;

/** 
* 先息后本
* @ClassName XianXiHouBenStrategy 
* @date 2019年10月17日 下午1:49:01 
* @author chify
*/
public class XianXiHouBenStrategy implements Strategy {

	public BigDecimal caculateInterest() {
		System.out.println("先息后本计算利息");
		return BigDecimal.ZERO;
	}

}
