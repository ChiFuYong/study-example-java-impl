package com.chifuyong.behavioralpatterns.strategy.impl;

import com.chifuyong.behavioralpatterns.strategy.api.Strategy;

import java.math.BigDecimal;

/** 
* 等额本金
* @date 2019年10月17日 下午1:45:13
* @author chify
*/
public class DengEBenJinStrategy implements Strategy {

	@Override
	public BigDecimal caculateInterest() {
		System.out.println("等额本金计算利息");
		return BigDecimal.ZERO;
	}

}
