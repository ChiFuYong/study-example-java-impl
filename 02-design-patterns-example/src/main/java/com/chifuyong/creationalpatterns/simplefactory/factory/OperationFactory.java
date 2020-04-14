package com.chifuyong.creationalpatterns.simplefactory.factory;

import com.chifuyong.creationalpatterns.simplefactory.impl.AddOperation;
import com.chifuyong.creationalpatterns.simplefactory.impl.DivisionOperation;
import com.chifuyong.creationalpatterns.simplefactory.impl.MultiplicationOperation;
import com.chifuyong.creationalpatterns.simplefactory.impl.SubtractionOperation;
import com.chifuyong.creationalpatterns.simplefactory.api.Operation;

/** 
* 运算操作的简单工厂生成类
* @date 2019年10月8日 上午10:46:23
* @author chify
*/
public class OperationFactory {
	
	/** 
	 * getOperation: 获取相应的运算操作类型的对象 <br/>  
	 * @param str 操作符
	 * @return
	 * @throws Exception 
	 */
	public static Operation getOperation(String str) throws Exception {
		//违背了开放封闭原则，假如有新运算还得修改此处
		Operation operation = null;
		switch (str) {
			case "-":	operation = new SubtractionOperation();		
				break;
			case "+":	operation = new AddOperation();	
				break;
			case "*":	operation = new MultiplicationOperation();	
				break;
			case "/":	operation = new DivisionOperation();	
				break;
			default:	throw new Exception("输入的操作符正确！");
		}
		return operation;
	}

}
