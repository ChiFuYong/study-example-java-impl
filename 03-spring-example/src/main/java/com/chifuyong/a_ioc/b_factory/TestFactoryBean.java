package com.chifuyong.a_ioc.b_factory;

import org.springframework.beans.factory.FactoryBean;

import java.util.Properties;

/**
 * 测试 Spring 的 FactoryBean
 *
 * @date： 2020/5/28
 * @author: chify
 */
public class TestFactoryBean implements FactoryBean<Properties> {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 通过此方法返回所需要的 bean
     * @return
     * @throws Exception
     */
    public Properties getObject() throws Exception {
        Properties properties = System.getProperties();
        Properties properties1 = new Properties();
        properties1.putAll(properties);
        properties1.put("testKey",name);
        return properties1;
    }

    /**
     * 返回 FactroryBean 创建的 bean 类型
     * @return
     */
    public Class<?> getObjectType() {
        return Properties.class;
    }

    /**
     * 配置返回的 bean 是否是单例的
     * 相当于 scope="singleton"
     * @return
     */
    public boolean isSingleton() {
        return true;
    }
}
