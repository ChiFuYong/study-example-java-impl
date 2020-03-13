package com.chifuyong.creationalpatterns.simplefactory.interfac;

/** 
* 运算接口
* @ClassName Operation 
* @date 2019年10月8日 上午10:55:56 
* @author chify
*/
public interface Operation {
	
	/** 
	 * getResult: 计算两个数的操作 <br/>  
	 * @author chify
	 * @param d1
	 * @param d2
	 * @return 
	 * @since JDK 1.8
	 */
	public Double getResult(Double d1, Double d2);
	
}
