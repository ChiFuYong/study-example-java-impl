package chifuyong.stack.impl;

import chifuyong.stack.Stack;

/**
 * @Auther: chify
 * @Date: 18/12/2019 18:27
 * @Description: 数组实现栈
 */
public class ArrayStackImpl<T> implements Stack<T> {

    /**
     * MAX_LENGTH: 栈默认最大长度
     */
    private final int DEFAULT_MAX_LENGTH = 10;

    /*
    * 元素数组
    * */
    T [] arrays;

    /*
    * 栈长度
    * */
    private int length;

    public ArrayStackImpl() {
        super();
        arrays = (T[]) new Object[DEFAULT_MAX_LENGTH];
        this.length=0;
    }

    @Override
    public T pop() {
        if (length <= 0)
            throw new RuntimeException("栈空，无数据可出栈！");
        length--;
        return (T)this.arrays[this.length];
    }

    @Override
    public int push(T ele) {
        if (this.length == this.arrays.length)
            throw new RuntimeException("栈已满，数据不可再进栈！");
        //进栈操作
        arrays[length] = ele;
        length++;
        return length;
    }

    @Override
    public int size() {
        return this.length;
    }
}
