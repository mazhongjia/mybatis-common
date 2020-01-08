package com.mzj;

import com.mzj.dao.MybatisCache2;
import com.mzj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: mazhongjia
 * @Date: 2020/1/8 13:48
 * @Version: 1.0
 */
public class MyBatisCache2Test {

    /**
     * 二级缓存
     */
    @Test
    public void testCache2() {

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

        MybatisCache2 userMapper = sqlSession.getMapper(MybatisCache2.class);

        System.out.println(userMapper.queryUserById("1"));

        sqlSession.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        MybatisCache2 mapper2 = sqlSession2.getMapper(MybatisCache2.class);

        System.out.println(mapper2.queryUserById("1"));
    }

}
