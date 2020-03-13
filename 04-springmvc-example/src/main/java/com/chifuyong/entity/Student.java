package com.chifuyong.entity;

/**
 * @Auther: chify
 * @Date: 22/12/2019 13:43
 * @Description: 实体
 */
public class Student {
    private String name ;
    private String id ;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
