package chifuyong.stack.impl;

import chifuyong.stack.Stack;

/**
 * @Auther: chify
 * @Date: 19/12/2019 07:53
 * @Description: 单链表实现栈（头插法）
 */
public class SingleLinkStack<T> implements Stack<T> {

    //节点类
    class Node<T>{
        public T data;//数据域
        public Node next;//指针：指向下一节点
    }

    private Node head;//头结点

    private int length;//栈长度

    @Override
    public T pop() {
        if(length<=0)
            throw new RuntimeException("栈空，无可用元素出栈！");
        Node temp = head.next;
        //头节点指针 > 栈顶指针的上一个元素
        head.next = head.next.next;
        length--;
        return (T) temp.data;
    }

    @Override
    public int push(T ele) {
        //链表实现，栈长度视内存而定（长度相当于无限）
        Node newNode = new Node();
        if (head==null){
            newNode.data = ele;
            head.next = newNode;
            length++;
            return length;
        }
        //头插法：因为栈的特殊性，这里头插法是最好的实现方式。
        //新节点指针 > 栈顶节点
        newNode.next = head.next;
        //头节点指针 > 新节点
        head.next = newNode;
        length++;
        return length;
    }

    @Override
    public int size() {
        return this.length;
    }
}
