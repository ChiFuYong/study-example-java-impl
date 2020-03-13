package com.chifuyong.creationalpatterns.singleton.customer;

import com.chifuyong.creationalpatterns.singleton.item.HungerManSingleton;
import com.chifuyong.creationalpatterns.singleton.item.LazyManSingleton;

public class TestSingleton {
	
	public static void main(String[] args) {
		//懒汉式
		LazyManSingleton lazy1 = LazyManSingleton.createInstance();
		LazyManSingleton lazy2 = LazyManSingleton.createInstance();
		System.out.print(" 判断  LazyManSingleton  是否是单例：  " );
		System.out.println(lazy1==lazy2);
		
		//饿汉式
		HungerManSingleton hunger1 = HungerManSingleton.createInstance();
		HungerManSingleton hunger2 = HungerManSingleton.createInstance();
		System.out.print(" 判断 HungerManSingleton 是否是单例：  ");
		System.out.println(hunger1==hunger2);
		
	}
}
