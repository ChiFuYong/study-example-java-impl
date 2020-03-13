package com.chifuyong.a_ioc.c_properties;

/**
 * @Auther: chify
 * @Date: 29/02/2020 11:17
 * @Description:
 */
public class Address {

    private String phone;
    private String addr;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Address{" +
                "phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
