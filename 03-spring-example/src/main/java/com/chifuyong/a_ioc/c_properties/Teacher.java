package com.chifuyong.a_ioc.c_properties;

import java.util.*;

/**
 * @Auther: chify
 * @Date: 29/02/2020 11:48
 * @Description:
 */
public class Teacher {
    private String[] arrayData;
    private List listData;
    private Set setData;
    private Map mapData;
    private Properties propertiesData;

    public void setArrayData(String[] arrayData) {
        this.arrayData = arrayData;
    }

    public void setListData(List listData) {
        this.listData = listData;
    }

    public void setSetData(Set setData) {
        this.setData = setData;
    }

    public void setMapData(Map mapData) {
        this.mapData = mapData;
    }

    public void setPropertiesData(Properties propertiesData) {
        this.propertiesData = propertiesData;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "arrayData=" + Arrays.toString(arrayData) +
                ", listData=" + listData +
                ", setData=" + setData +
                ", mapData=" + mapData +
                ", propertiesData=" + propertiesData +
                '}';
    }
}
