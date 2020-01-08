package com.mzj;

import com.mzj.dao.DynamicSql;
import com.mzj.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Auther: mazhongjia
 * @Date: 2020/1/8 10:53
 * @Version: 1.0
 */
public class DynamicSqlTest {

    private DynamicSql userMapper;

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

        this.userMapper = sqlSession.getMapper(DynamicSql.class);
    }

    /**
     * 测试：if
     */
    @Test
    public void testqueryUserList() {
        List<User> users = this.userMapper.queryUserList(null);
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("--------------");
        List<User> users2 = this.userMapper.queryUserList("静静");
        for (User user : users2) {
            System.out.println(user);
        }
    }

    /**
     * 测试：choose when otherwise
     */
    @Test
    public void queryUserListByNameOrAge() throws Exception {
        List<User> users = this.userMapper.queryUserListByNameOrAge(null, 21);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试：where 和set  场景1
     */
    @Test
    public void queryUserListByNameAndAge() throws Exception {
        List<User> users = this.userMapper.queryUserListByNameAndAge("鹏程", 21);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试：where 和set  场景2
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静静");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("Jinjin");
        user.setId("1");
        this.userMapper.updateUser(user);
    }

    /**
     * 测试：foreach
     */
    @Test
    public void queryUserListByIds() throws Exception {
        List<User> users = this.userMapper.queryUserListByIds(new String[]{"1","3"});
        for (User user : users) {
            System.out.println(user);
        }
    }
}
