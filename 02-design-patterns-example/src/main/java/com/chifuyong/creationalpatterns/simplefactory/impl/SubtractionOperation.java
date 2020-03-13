package com.chifuyong.creationalpatterns.simplefactory.impl;

import com.chifuyong.creationalpatterns.simplefactory.interfac.Operation;

/** 
* 减法运算实现类
* @ClassName SubtractionOperation 
* @date 2019年10月8日 上午11:01:30 
* @author chify
*/
public class SubtractionOperation implements Operation {

	@Override
	public Double getResult(Double d1, Double d2) {
		return d1-d2;
	}


}