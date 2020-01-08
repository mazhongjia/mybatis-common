package com.mzj.dao;

import com.mzj.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SqlInject {

    /**
     * 根据名字查询用户信息（直接使用注解指定传入参数名称）
     * @param tableName
     * @return
     */
    public List<User> testFindUserByNameFalse(@Param("value") String tableName);

    /**
     * 根据名字查询用户信息（直接使用注解指定传入参数名称）
     * @param tableName
     * @return
     */
    public List<User> testFindUserByNameTrue(@Param("value") String tableName);
}
