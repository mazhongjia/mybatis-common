package com.mzj.dao;

import com.mzj.pojo.User;

public interface MybatisCache2 {

    /**
     * 一级缓存
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(String id);

    /**
     * 根据id更新用户信息
     * @param user
     */
    public void updateUser(User user);
}
