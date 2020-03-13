package chifuyong.list.impl;

import chifuyong.list.List;

/** 
* 顺序表的实现（底层使用数组）
* @ClassName ArrayListImpl
* @date 2019年9月30日 上午10:45:08 
* @author chify
*/
public class ArrayListImpl<T> implements List<T> {
	
	/** 
	 * MAX_LENGTH: 线性表默认最大长度
	 * @since JDK 1.8
	 */  
	private final int DEFAULT_MAX_LENGTH = 10;

	/** 
	 * arrays: 元素数组
	 * @since JDK 1.8
	 */  
	private T arrays[];
	
	/** 
	 * length: 元素个数
	 * @since JDK 1.8
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

	/* 返回元素个数
	 * @see com.chifuyong.list.List#size()
	 */
	@Override
	public int size() {
		return length;
	}

	/* 插入元素
	 * @see com.chifuyong.list.List#insert(java.lang.Object, int)
	 */
	@Override
	public int insert(T element) {
		if(length >= arrays.length) {
			System.out.println("插入失败，元素个数超过线性表最大长度！");
			return -1;
		}
		arrays[length]= element;
		length++;
		return length;
	}

	/* 删除指定位置元素
	 * @see com.chifuyong.list.List#delete(int)
	 */
	@Override
	public int delete(int location) {
		if(location<1 || location>length) {
			System.out.println("给定位置不符合要求");
			return -1;
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
			System.out.println("给定位置不符合要求");
			return -1;
		}
		arrays[location-1] = element;
		return 1;
	}

	@Override
	public T getElement(int location) {
		if(location<1 || location>length) {
			System.out.println("给定位置不符合要求");
			return null;
		}
		
		return arrays[location-1];
	}

	@Override
	public int serachElement(T element) {
		int index = -1;
		for (int i = 0; i < arrays.length; i++) {
			if(element.equals(arrays[i])){
				index = ++i;
			}
		}
		return index;
	}




}
