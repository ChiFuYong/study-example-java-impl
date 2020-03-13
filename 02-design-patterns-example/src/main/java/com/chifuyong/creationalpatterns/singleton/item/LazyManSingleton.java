package com.chifuyong.creationalpatterns.singleton.item;

/** 
* 懒汉式单例类（会有线程并发问题，需要处理）
* @ClassName SingletonClass 
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
	 * @since JDK 1.8
	 */  
	public static LazyManSingleton instance;
	
	/** 
	 * createInstance: 静态方法获取单例对象 <br/>  
	 * @author chify
	 * @return 
	 * @since JDK 1.8
	 */
	public static synchronized LazyManSingleton createInstance(){
		if(instance == null) {
			instance = new LazyManSingleton();
		}
		return instance;
	}
	
}
