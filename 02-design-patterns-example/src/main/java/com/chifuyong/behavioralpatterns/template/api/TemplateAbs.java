package com.chifuyong.behavioralpatterns.template.api;

/** 
* 模版方法抽象类
* @date 2019年11月13日 下午2:44:00
* @author chify
*/
public abstract class TemplateAbs {
	
	/** 
	 * publicMethod: 抽象方法（拥有大量公用重复的逻辑） <br/>
	 * @author chify 
	 * @since JDK 1.8
	 */
	public final void publicMethod() {
		System.out.println("-----------------------------");
		System.out.println(" 这里是一些公共、大量重复的逻辑！ ");
		
		this.doMethod();
		
		System.out.println(" 这里是一些公共、大量重复的逻辑！ ");
		System.out.println("-----------------------------");
	}

	/** 
	 * doMethod: 特有方法（需子类重写） <br/>  
	 * @author chify 
	 * @since JDK 1.8
	 */
	protected abstract void doMethod();

}
