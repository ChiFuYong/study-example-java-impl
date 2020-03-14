package com.chifuyong;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @Auther: chify
 * @Date: 14/03/2020 09:33
 * @Description:
 */
public class JedisTest {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("127.0.0.1",7000);
        //增、改
        String result = jedis.set("name","光");
        System.out.println("result = " + result);
        //查询
        String result1 = jedis.get("name");
        System.out.println("result1 = " + result1);
        //删除
        Long index = jedis.del("name");
        System.out.println("index = " + index);
    }

}
