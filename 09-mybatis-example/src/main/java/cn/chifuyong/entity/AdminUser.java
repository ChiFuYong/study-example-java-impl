package cn.chifuyong.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * admin_user
 * @author 
 */
@Data
public class AdminUser implements Serializable {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户登录名称
     */
    private String userName;

    /**
     * 第一人称
     */
    private String firstName;

    /**
     * 登录密码
     */
    private String passWd;

    /**
     * 个性签名
     */
    private String signature;

    private static final long serialVersionUID = 1L;
}