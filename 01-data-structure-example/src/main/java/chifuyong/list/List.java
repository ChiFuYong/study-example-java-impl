package chifuyong.list;

/** 
* 线性表接口
* @ClassName List 
* @date 2019年9月30日 下午4:20:27 
* @author chify
*/
public interface List<T>{
	
	/** 
	 * size: 返回线性表中元素个数 <br/>  
	 * @author chify
	 * @return 
	 * @since JDK 1.8
	 */
	public int size();
	
	/** 
	 * insert: 插入元素，成功返回元素当前位置，否则-1 <br/>  
	 * @author chify
	 * @param element
	 * @return 
	 * @since JDK 1.8
	 */
	public int insert(T element);
	
	/** 
	 * delete: 删除元素，成功返回1，否则-1 <br/>  
	 * @author chify
	 * @param location
	 * @return 
	 * @since JDK 1.8
	 */
	public int delete(int location);
	
	/** 
	 * modify: 修改给定位置的元素，成功返回1，否则-1 <br/>  
	 * @author chify
	 * @param element
	 * @param location
	 * @return 
	 * @since JDK 1.8
	 */
	public int modify(T element, int location);
	
	/** 
	 * getElement: 获取线性表中给定位置的元素 <br/>  
	 * @author chify
	 * @param location
	 * @return 
	 * @since JDK 1.8
	 */
	public T getElement(int location);
	
	/** 
	 * serachElement: 查找某个元素，若线性表中存在，返回存在的第一个元素所在位置，否则返回-1 <br/>  
	 * @author chify
	 * @param element
	 * @return 
	 * @since JDK 1.8
	 */
	public int serachElement(T element);
	
	
	
	
}
