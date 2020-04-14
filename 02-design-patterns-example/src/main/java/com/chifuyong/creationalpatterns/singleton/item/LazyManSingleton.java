package com.chifuyong.creationalpatterns.singleton.item;

/** 
* 懒汉式单例类（会有线程并发问题，需要处理）
* @date 2019年11月13日 下午3:02:23
* @author chify
*/
public class LazyManSingleton{
	/** 
	 * 私有化构造方法，不让在其他类中创建实例。
	 */ 
	private LazyManSingleton(){};
	
	/** 
	 * instance: 定义一个 LazyManSington 类型的成员变量
	 */
	public static LazyManSingleton instance;
	
	/** 
	 * createInstance: 静态方法获取单例对象 <br/>  
	 * @return
	 */
	public static synchronized LazyManSingleton createInstance(){
		//使用 synchronized 防止多线程调用下，出现多实例，保证线程安全
		if(instance == null) {
			instance = new LazyManSingleton();
		}
		return instance;
	}
	
}
