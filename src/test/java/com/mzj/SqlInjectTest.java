package com.mzj;

import com.mzj.dao.SqlInject;
import com.mzj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Auther: mazhongjia
 * @Date: 2020/1/8 09:45
 * @Version: 1.0
 */
public class SqlInjectTest {

    private SqlInject userMapper;

    @Before
    public void setUp() throws Exception {
        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        this.userMapper = sqlSession.getMapper(SqlInject.class);
    }

    @Test
    public void testFindUserByNameFalse() throws Exception{
        List<User> list=userMapper.testFindUserByNameFalse("' or '1'='1");
        System.out.println(list);
    }

    @Test
    public void testFindUserByNameTrue() throws Exception{
        List<User> list=userMapper.testFindUserByNameTrue("' or '1'='1");
        System.out.println(list);
    }

}
