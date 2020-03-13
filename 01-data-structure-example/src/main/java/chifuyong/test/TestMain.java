package chifuyong.test;


import chifuyong.list.impl.ArrayListImpl;
import chifuyong.list.List;

public class TestMain {
	
	
	public static void main(String[] args) {
		
		testArrayList();
		
	}
	
	/** 
	 * testArrayList: 测试顺序表 <br/>  
	 * @author chify 
	 * @since JDK 1.8
	 */
	private static void testArrayList() {
		List<String> list = new ArrayListImpl<String>();
		
		System.out.println("------------------");
		
		System.out.println("插入第 1 个数："+list.insert("Test次数：1"));
		System.out.println("List长度:"+list.size());
		
		System.out.println("------------------");
		
		System.out.println("插入第 2 个数："+list.insert("Test次数：2"));
		System.out.println("List长度:"+list.size());
		System.out.println("------------------");
		
		System.out.println("插入第 3 个数："+list.insert("Test次数：3"));
		System.out.println("List长度:"+list.size());
		
		System.out.println("------------------");
		
		System.out.println("插入第 4 个数："+list.insert("Test次数：4"));
		System.out.println("List长度:"+list.size());
		
		System.out.println("------------------");
		
		System.out.println("插入第 5 个数："+list.insert("Test次数：5"));
		System.out.println("List长度:"+list.size());
		
		System.out.println("------------------");
		
		System.out.println("插入第 6 个数："+list.insert("Test次数：6"));
		System.out.println("List长度:"+list.size());
		
		System.out.println("------------------");
		
		System.out.println("插入第 7 个数："+list.insert("Test次数：7"));
		System.out.println("List长度:"+list.size());
		
		System.out.println("------------------");
		
		System.out.println("插入第 8 个数："+list.insert("Test次数：8"));
		System.out.println("List长度:"+list.size());
		
		System.out.println("------------------");
		
		System.out.println("插入第 9 个数："+list.insert("Test次数：9"));
		System.out.println("List长度:"+list.size());
		
		System.out.println("------------------");
		
		System.out.println("插入第 10 个数："+list.insert("Test次数：10"));
		System.out.println("List长度:"+list.size());
		
		System.out.println("------------------");
		
		System.out.println("获取第 2 个数："+list.getElement(2));
		System.out.println("删除第 2 个数：" + list.delete(2));
		System.out.println("第 2 个数现在为："+list.getElement(2));
		System.out.println("删除后长度：" + list.size());  
		
		System.out.println("------------------");
		
		System.out.println("------------------");
		
		System.out.println("获取第 2 个数："+list.getElement(2));
		System.out.println("修改第 2 个数：" + list.modify("Test次数：2", 2));
		System.out.println("第 2 个数现在为："+list.getElement(2));
		System.out.println("修改后长度：" + list.size());  
		
		System.out.println("------------------");
		
		System.out.println("查找元素：Test次数：2"+list.serachElement("Test次数：2"));
	}
	
	
}
