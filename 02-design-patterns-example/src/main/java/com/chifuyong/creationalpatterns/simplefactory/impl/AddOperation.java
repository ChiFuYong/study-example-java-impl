package com.chifuyong.creationalpatterns.simplefactory.impl;

import com.chifuyong.creationalpatterns.simplefactory.api.Operation;

/** 
* 加法运算实现类
* @date 2019年10月8日 上午11:00:11
* @author chify
*/
public class AddOperation implements Operation {

	@Override
	public Double getResult(Double d1, Double d2) {
		return d1+d2;
	}

}
