package com.chifuyong.entity;

import java.util.List;
import java.util.Map;

/**
 * @Auther: chify
 * @Date: 22/12/2019 15:14
 * @Description: 包装参数类
 */
public class Request {

    private Student student;

    private List<Student> list;

    private Map<String,String> maps;

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public List<Student> getList() {
        return list;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Request{" +
                "student=" + student +
                ", list=" + list +
                ", maps=" + maps +
                '}';
    }
}
