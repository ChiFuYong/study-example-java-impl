package chifuyong.queue.impl;

import chifuyong.queue.Queue;


/**
 * @Auther: chify
 * @Date: 19/12/2019 11:03
 * @Description: 数组实现循环队列(可防止假溢出问题)
 */
public class ArrayQueue<T> implements Queue<T> {
    /**
     * 队列数组的默认长度
     */
    private final int DEFAULT_MAX_LENGTH = 10;

    /*
     * 元素数组
     * */
    T [] arrays = (T[]) new Object[DEFAULT_MAX_LENGTH];

    /*
    * 队头标识
    * */
    private int front=0;

    /*
    * 队尾标识
    * */
    private int rear=0;

    /*
    * rear == front 时，队空
    * (rear+1)%DEFAULT_MAX_LENGTH == front 时，队满
    * */
    @Override
    public int addElement(T data) {
        if((rear+1)%DEFAULT_MAX_LENGTH == front)
            throw new RuntimeException("队满，不可再插入元素！");
        arrays[rear] = data;
        if (rear < DEFAULT_MAX_LENGTH - 1){
            rear++;
        }else {
            rear = 0;
        }
        //返回的逻辑序列就是栈的长度
        return this.size();
    }

    @Override
    public T getHead() {
        if (rear == front)
            throw new RuntimeException("队空，无元素可出队");
        T data = arrays[front];
        front++;
        return data;
    }

    @Override
    public int size() {
        return (rear - front + DEFAULT_MAX_LENGTH)%DEFAULT_MAX_LENGTH;
    }
}
