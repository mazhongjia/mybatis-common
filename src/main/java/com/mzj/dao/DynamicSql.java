package com.mzj.dao;

import com.mzj.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: mazhongjia
 * @Date: 2020/1/8 10:48
 * @Version: 1.0
 */
public interface DynamicSql {

    /**
     * 1、动态SQL之——if
     * 场景：查询男性用户，如果输入了姓名，则在其基础上增加按姓名查询
     * @param name
     * @return
     */
    List<User> queryUserList(@Param("name") String name);

    /**
     * 2、动态SQL之——choose when otherwise
     *
     * 场景：查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找姓名为“鹏程”的用户。
     * @param name
     * @param age
     * @return
     */
    List<User> queryUserListByNameOrAge(@Param("name") String name,@Param("age") Integer age);

    /**
     * 3、动态SQL之——where 和set
     *
     * 场景一：查询所有用户，如果输入了姓名按照姓名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立
     * @param name
     * @param age
     * @return
     */
    List<User> queryUserListByNameAndAge(@Param("name") String name,@Param("age") Integer age);

    /**
     * 3、动态SQL之——where 和set
     * 场景二：根据id更新用户信息
     *
     * @param user
     */
    public void updateUser(User user);


    /**
     * 4、动态SQL之——foreach
     * 按照多个id查询用户信息
     * @param ids
     * @return
     */
    List<User> queryUserListByIds(@Param("ids") String[] ids);
}
