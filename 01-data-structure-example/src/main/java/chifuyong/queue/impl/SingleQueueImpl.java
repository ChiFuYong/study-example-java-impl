package chifuyong.queue.impl;

import chifuyong.queue.Queue;
import com.sun.xml.internal.ws.api.pipe.NextAction;

/**
 * @Auther: chify
 * @Date: 19/12/2019 21:48
 * @Description: 单链表实现队列（尾插法）
 */
public class SingleQueueImpl<T> implements Queue<T>{

    //节点类
    class Node<T>{
        public T data;//数据域
        public Node next;//指针：指向下一节点
    }

    private Node head;//头结点

    private int length;//队列长度

    @Override
    public int addElement(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head==null){
            head.next = newNode;
            length++;
            return length;
        }
        //尾插法实现插入(方便获取队头元素)
        Node temp = head.next;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        length++;
        return length;
    }

    @Override
    public T getHead() {
        if (length<=0)
            throw new RuntimeException("队列为空，无元素可获取");
        Node temp = head.next;
        head.next = head.next.next;
        return (T)temp.data;
    }

    @Override
    public int size() {
        return length;
    }
}
