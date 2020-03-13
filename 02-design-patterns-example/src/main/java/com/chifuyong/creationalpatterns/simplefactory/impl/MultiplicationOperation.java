package com.chifuyong.creationalpatterns.simplefactory.impl;

import com.chifuyong.creationalpatterns.simplefactory.interfac.Operation;

/** 
* 乘法运算实现类
* @ClassName MultiplicationOperation 
* @date 2019年10月8日 上午11:00:54 
* @author chify
*/
public class MultiplicationOperation implements Operation {

	@Override
	public Double getResult(Double d1, Double d2) {
		return d1*d2;
	}

}
