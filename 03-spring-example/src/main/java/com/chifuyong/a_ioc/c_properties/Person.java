package com.chifuyong.a_ioc.c_properties;

/**
 * @Auther: chify
 * @Date: 29/02/2020 11:11
 * @Description:
 */
public class Person {

    private String name;
    private Integer age;
    private String sex;
    private Address homeAddr;
    private Address companyAddr;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHomeAddr(Address homeAddr) {
        this.homeAddr = homeAddr;
    }

    public void setCompanyAddr(Address companyAddr) {
        this.companyAddr = companyAddr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", homeAddr=" + homeAddr +
                ", companyAddr=" + companyAddr +
                '}';
    }
}
