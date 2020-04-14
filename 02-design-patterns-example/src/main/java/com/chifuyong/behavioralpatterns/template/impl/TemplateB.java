package com.chifuyong.behavioralpatterns.template.impl;

import com.chifuyong.behavioralpatterns.template.api.TemplateAbs;

/** 
* 子类B
* @date 2019年11月13日 下午2:49:26
* @author chify
*/
public class TemplateB extends TemplateAbs {

	@Override
	protected void doMethod() {
		System.out.println("-----------------------------");
		System.out.println(" TemplateB 私有的方法！");
		System.out.println("-----------------------------");
	}

}
