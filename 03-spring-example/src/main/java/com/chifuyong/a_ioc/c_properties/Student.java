package com.chifuyong.a_ioc.c_properties;

/**
 * @Auther: chify
 * @Date: 29/02/2020 10:09
 * @Description:
 */
public class Student {

    private String name ;
    private Integer age;
    private String sex;
    private Address address;

    public Student(String name, Integer age, String sex,Address address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address=" + address +
                '}';
    }
}
