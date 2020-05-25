package com.chifuyong.baozhuanglei.problem;

import org.junit.Test;

/**
 * Demo
 *
 * @date： 2020/4/25
 * @author: chify
 */
public class TestDemo {

    @Test
    public void test(){
        Person person = new Person();
        person.setName("person");
        // Person 的 Age 为 Integer 类型
        person.setAge(null);
        Student student = new Student();
        student.setName("student");
        // Student 的 Age 为 Int 类型
        student.setAge(person.getAge());
    }

    @Test
    public void test2(){
        Integer i = 20;
        Integer i2 = 20;
        Integer i3 = new Integer(20);
        System.out.println(i == i2);//true
        System.out.println(i2 == i3);//false
        char c = 66;
        int i4 = c;
        System.out.println(c == i4);
    }

}
