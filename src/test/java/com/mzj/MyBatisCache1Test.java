package com.mzj;

import com.mzj.dao.MybatisCache1;
import com.mzj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: mazhongjia
 * @Date: 2020/1/8 13:48
 * @Version: 1.0
 */
public class MyBatisCache1Test {

    /**
     * 一级缓存
     */
    @Test
    public void testCache1() {

        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        MybatisCache1 userMapper = sqlSession.getMapper(MybatisCache1.class);

        System.out.println(userMapper.queryUserById("1"));
        System.out.println(userMapper.queryUserById("1"));
    }

    @Test
    public void testQueryUserByIdClearCache() {
        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        MybatisCache1 userMapper = sqlSession.getMapper(MybatisCache1.class);


        System.out.println(userMapper.queryUserById("1"));
        sqlSession.clearCache();//清除一级缓存
        System.out.println(userMapper.queryUserById("1"));
    }

    @Test
    public void testQueryUserById4UpdateAutoClearCache() {
        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        MybatisCache1 userMapper = sqlSession.getMapper(MybatisCache1.class);

        System.out.println(userMapper.queryUserById("1"));
        //sqlSession.clearCache();

        User user=new User();
        user.setName("美女");
        user.setId("2");
        userMapper.updateUser(user);

        System.out.println(userMapper.queryUserById("1"));
    }
}
