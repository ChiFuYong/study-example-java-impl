package com.chifuyong.behavioralpatterns.strategy.impl;

import com.chifuyong.behavioralpatterns.strategy.api.Strategy;

import java.math.BigDecimal;

/** 
* 分期还本
* @date 2019年10月17日 下午1:51:55
* @author chify
*/
public class FenQiHuanBenStrategy implements Strategy {

	@Override
	public BigDecimal caculateInterest() {
		System.out.println("分期还本计算利息");
		return BigDecimal.ZERO;
	}

}
