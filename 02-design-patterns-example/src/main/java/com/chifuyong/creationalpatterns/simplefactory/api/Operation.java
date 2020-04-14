package com.chifuyong.creationalpatterns.simplefactory.api;

/** 
* 运算接口
* @date 2019年10月8日 上午10:55:56
* @author chify
*/
public interface Operation {
	
	/** 
	 * getResult: 运算操作 <br/>
	 * @param d1
	 * @param d2
	 * @return 
	 */
	public Double getResult(Double d1, Double d2);
	
}
