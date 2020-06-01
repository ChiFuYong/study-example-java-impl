package chifuyong.list.impl;

import chifuyong.list.List;

/**
 * 单链表实现类
 *
 * @Date: 2020/6/1
 * @author: chify
 */
public class SingleLinkListImpl<T> implements List<T> {

	/**
	 * 节点类
	 */
	private class Node<T>{
		
		private T data;//数据域
		
		private Node next;//指向下一个节点元素
	}
	
	/** 
	 * head: 头结点
	 */
	private Node head;
	
	/** 
	 * length: 长度
	 */
	private int length;

	@Override
	public int size() {
		return length;
	}

	/**
	 * 头插法
	 */
	@Override
	public int insert(T element) {
		Node newNode = new Node<T>();
		newNode.data = element;
		if(head==null) { //头结点为Null时，表示单链表还未插入元素
			head = new Node();
			head.next = newNode;
			length++;
			return 1;
		}
		//新节点的指针 > 头节点指针指向的节点
		newNode.next = head.next;
		//头结点的指针 > 新节点
		head.next = newNode;
		length++;
		return 1;
	}

	/**
	 * 尾插法
	 */
	public int insert2(T element) {
		Node newNode = new Node<T>();
		newNode.data = element;
		if(head==null) { //头结点为Null时，表示单链表还未插入元素
			head = new Node();
			head.next = newNode;
			length++;
			return 1;
		}
		//循环单链表，直到最后一个元素：指针为Null的元素，
		Node temp = head.next;
		while(temp.next != null){
			temp = temp.next;
		}
		//在最后一个元素后面插入行元素
		temp.next = newNode;
		this.length++;
		return 1;
	}

	@Override
	public int delete(int location) {
		if (location <0 ) {
			throw new RuntimeException("给定位置不能为负数！");
		}
		if(this.length<location) {
			throw new RuntimeException("给定位置超出链表长度！");
		}
		Node temp = head.next;
		for (int i = 0;i < location-2;i++){//循环取到要删除的前一个元素
			temp = temp.next;
		}
		//将 待删除节点的前一个节点的指针 > 待删除节点指针指向的节点
		temp.next = temp.next.next;
		this.length--;
		return 1;
	}

	@Override
	public int modify(T element, int location) {
		if (location <0 ) {
			throw new RuntimeException("给定位置不能为负数！");
		}
		if(this.length<location) {
			throw new RuntimeException("给定位置超出链表长度！");
		}
		Node temp = head.next;
		for(int i =0; i < location-1;i++){
			//取到要修改的节点
			temp = temp.next;
		}
		temp.data = element;
		return 1;
	}

	@Override
	public T getElement(int location) {
		if (location <0 ) {
			throw new RuntimeException("给定位置不能为负数！");
		}
		if(this.length<location) {
			throw new RuntimeException("给定位置超出链表长度！");
		}
		Node temp = head.next;
		for(int i =0; i < location-1;i++){
			//取到给定位置的节点
			temp = temp.next;
		}
		return (T)temp.data;
	}

	@Override
	public int serachElement(T element) {
		int i = 0;
		Node temp = head.next;
		while (temp.next != null) {
			i++;
			if(temp.data == element){
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}
	

}
