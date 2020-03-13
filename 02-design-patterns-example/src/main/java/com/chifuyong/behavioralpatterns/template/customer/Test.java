package com.chifuyong.behavioralpatterns.template.customer;

import com.chifuyong.behavioralpatterns.template.api.TemplateAbs;
import com.chifuyong.behavioralpatterns.template.impl.TemplateA;
import com.chifuyong.behavioralpatterns.template.impl.TemplateB;

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
