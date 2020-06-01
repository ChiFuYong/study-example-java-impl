package chifuyong.list;


import chifuyong.list.impl.ArrayListImpl;
import org.junit.Test;

/**
 * 客户端测试类
 *
 * @Date: 2020/6/1
 * @author: chify
 */
public class Consumer {

	@Test
	public void testArrayList() {
		List<String> list = new ArrayListImpl<String>();
		for (int i = 0; i<10 ;i++){
			list.insert("第" + i + "次插入");
			int j = i+1;
			System.out.println("插入第" + j +" 个数");
			System.out.println("现在个数为：" + list.size());
			System.out.println("------------------");
		}
		// get、delete
		System.out.println("获取第 2 个数："+list.getElement(2));
		System.out.println("删除第 2 个数：" + list.delete(2));
		System.out.println("第 2 个数现在为："+list.getElement(2));
		System.out.println("删除后长度：" + list.size());
		System.out.println("------------------");
		// get、modify
		System.out.println("获取第 2 个数："+list.getElement(2));
		System.out.println("修改第 2 个数：" + list.modify("次数：2", 2));
		System.out.println("第 2 个数现在为："+list.getElement(2));
		System.out.println("修改后长度：" + list.size());
		System.out.println("------------------");
		// ser
		System.out.println("次数：2 所在位置为: " + list.serachElement("次数：2"));
	}

}
