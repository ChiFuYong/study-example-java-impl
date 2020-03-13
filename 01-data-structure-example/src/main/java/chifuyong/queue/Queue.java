package chifuyong.queue;

/**
 * @Auther: chify
 * @Date: 18/12/2019 18:24
 * @Description: 队列接口
 */
public interface Queue<T> {

    /*
    * 队尾插入新的元素，返回新元素的逻辑序列
    * */
    public int addElement (T data);

    /*
    * 返回队头元素，并删除队头
    * */
    public T getHead();

    /*
    * 获取队列长度
    * */
    public int size();
}
