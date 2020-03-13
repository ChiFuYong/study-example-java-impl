package chifuyong.stack;

/**
 * @Auther: chify
 * @Date: 18/12/2019 18:25
 * @Description: 栈接口
 */
public interface Stack<T> {
    /*
    * 出栈
    * */
    public T pop();

    /*
    * 进栈，返回元素的逻辑序列
    * */
    public int push(T ele);

    /*
    * 返回栈的长度
    * */
    public int size();
}
