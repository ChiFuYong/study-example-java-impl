package chifuyong.list;

/**
 * 线性表接口
 *
 * @Date: 2020/6/1
 * @author: chify
 */
public interface List<T>{
	
	/** 
	 * size: 返回线性表中元素个数 <br/>  
	 * @return
	 */
	public int size();
	
	/** 
	 * insert: 插入元素，成功返回元素当前位置，否则-1 <br/>  
	 * @param element
	 * @return 
	 */
	public int insert(T element);
	
	/** 
	 * delete: 删除元素，成功返回1，否则-1 <br/>  
	 * @param location
	 * @return 
	 */
	public int delete(int location);
	
	/** 
	 * modify: 修改给定位置的元素，成功返回1，否则-1 <br/>  
	 * @param element
	 * @param location
	 * @return 
	 */
	public int modify(T element, int location);
	
	/** 
	 * getElement: 获取线性表中给定位置的元素 <br/>  
	 * @param location
	 * @return
	 */
	public T getElement(int location);
	
	/** 
	 * serachElement: 查找某个元素，若线性表中存在，返回存在的第一个元素所在位置，否则返回-1 <br/>  
	 * @param element
	 * @return 
	 */
	public int serachElement(T element);
	
	
	
	
}
