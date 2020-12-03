package cn.chifuyong.mapper;

import cn.chifuyong.entity.AdminUser;

public interface AdminUserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}