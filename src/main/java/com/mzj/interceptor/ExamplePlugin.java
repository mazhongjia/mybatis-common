package com.mzj.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @Auther: mazhongjia
 * @Date: 2020/1/7 16:50
 * @Version: 1.0
 */
// ExamplePlugin.java
@Intercepts({@Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class})})
public class ExamplePlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
//        System.out.println("11111");
        return invocation.proceed();
    }
    public Object plugin(Object target) {
//        System.out.println("22222");
        return Plugin.wrap(target, this);
    }
    public void setProperties(Properties properties) {
    }
}

