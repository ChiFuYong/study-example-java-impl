package com.chifuyong.behavioralpatterns.template.customer;

import com.chifuyong.behavioralpatterns.template.api.TemplateAbs;
import com.chifuyong.behavioralpatterns.template.impl.TemplateA;
import com.chifuyong.behavioralpatterns.template.impl.TemplateB;

/**
 * 客户端测试类
 *
 * @Date: 2020/4/14
 * @author: chify
 */
public class Test {
	public static void main(String[] args) {
		// TemplateA
		TemplateAbs templateA = new TemplateA();
		templateA.publicMethod();
		System.out.println();
		
		// TemplateB
		TemplateAbs templateB = new TemplateB();
		templateB.publicMethod();
	}
}
