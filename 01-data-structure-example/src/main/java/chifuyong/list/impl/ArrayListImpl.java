package chifuyong.list.impl;

import chifuyong.list.List;

/**
 * 顺序表的实现（底层使用数组）
 *
 * @Date: 2020/6/1
 * @author: chify
 */
public class ArrayListImpl<T> implements List<T> {
	
	/** 
	 * MAX_LENGTH: 线性表默认最大长度
	 */
	private final int DEFAULT_MAX_LENGTH = 10;

	/** 
	 * arrays: 元素数组
	 */
	private T[] arrays;
	
	/** 
	 * length: 元素个数
	 */
	private int length;
	
	/** 
	 * 构造方法：无参构造使用默认最大长度
	 */ 
	public ArrayListImpl() {
		super();
		arrays = (T[]) new Object[DEFAULT_MAX_LENGTH];
	}

	/** 
	 * 构造方法：自定义最大长度构造方法
	 */
	public ArrayListImpl(int max) {
		super();
		arrays = (T[]) new Object[max];
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public int insert(T element) {
		if(length >= arrays.length) {
			throw new RuntimeException("插入失败，元素个数超过线性表最大长度！");
		}
		arrays[length]= element;
		length++;
		return length;
	}

	@Override
	public int delete(int location) {
		if(location<1 || location>length) {
			throw new RuntimeException("给定位置不符合要求！");
		}
		//将location后的元素往前移动
		for (int i = location; i < length; i++) {
			arrays[i-1] = arrays[i];
		}
		length--;
		return 1;
	}

	@Override
	public int modify(T element, int location) {
		if(location<1 || location>length) {
			throw new RuntimeException("给定位置不符合要求！");
		}
		arrays[location] = element;
		return 1;
	}

	@Override
	public T getElement(int location) {
		if(location<1 || location>length) {
			throw new RuntimeException("给定位置不符合要求！");
		}
		return arrays[location];
	}

	@Override
	public int serachElement(T element) {
		int index = -1;
		for (int i = 0; i < arrays.length; i++) {
			if(element.equals(arrays[i])){
				index = i;
				break;
			}
		}
		return index;
	}

}
