package com.chifuyong.behavioralpatterns.template.impl;

import com.chifuyong.behavioralpatterns.template.api.TemplateAbs;

/** 
* 子类A
* @ClassName TemplteA 
* @date 2019年11月13日 下午2:47:36 
* @author chify
*/
public class TemplateA extends TemplateAbs {

	@Override
	protected void doMethod() {
		System.out.println("-----------------------------");
		System.out.println(" TemplateA 私有的方法！");
		System.out.println("-----------------------------");
	}

}
