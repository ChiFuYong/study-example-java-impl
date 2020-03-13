package com.chifuyong.creationalpatterns.singleton.item;

/** 
* 饿汉式单例类
* @ClassName HungerManSington 
* @date 2019年11月13日 下午3:11:56 
* @author chify
*/
public class HungerManSingleton {
	/** 
	 * 私有化构造方法，不让在其他类中创建实例。
	 */ 
	private HungerManSingleton(){};
	
	/** 
	 * instance: 定义一个 HungerManSington 类型的成员变量(初始化直接 new 一个新对象，防止并发问题)
	 * @since JDK 1.8
	 */  
	public static HungerManSingleton instance = new HungerManSingleton();
	
	/** 
	 * createInstance: 静态方法获取单例对象 <br/>  
	 * @author chify
	 * @return 
	 * @since JDK 1.8
	 */
	public static HungerManSingleton createInstance(){
		return instance;
	}
}
