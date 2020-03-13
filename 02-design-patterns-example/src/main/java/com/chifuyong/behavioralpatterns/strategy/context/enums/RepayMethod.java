package com.chifuyong.behavioralpatterns.strategy.context.enums;

public enum RepayMethod {
	/** 
	 * EI: 等额本息
	 * @since JDK 1.8
	 */  
	EI("等额本息"),
	/** 
	 * EP: 等额本金
	 * @since JDK 1.8
	 */  
	EP("等额本金"),
	/** 
	 * PI: 先息后本
	 * @since JDK 1.8
	 */  
	PI("先息后本"),
	/** 
	 * OT: 一次性还本付息
	 * @since JDK 1.8
	 */  
	OT("一次性还本付息"),
	/** 
	 * SG: 分期还本
	 * @since JDK 1.8
	 */  
	SG("分期还本"),
	/** 
	 * WL: 随借随还
	 * @since JDK 1.8
	 */  
	WL("随借随还")
	;

	private String desc;

	RepayMethod(String desc) {
		this.desc=desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
