package cn.cls.mybatis;

import cn.cls.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {

    @Test
    public void testInsert() throws IOException {
        // 获取配置文件字节流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 通过工厂构建器创建sql会话工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        // sql会话工厂开启会话,自动提交事务
        SqlSession sqlSession = factory.openSession(true);
        // 获取mapper实现
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //
        int result = mapper.insertUser();
        // 提交事务
//        sqlSession.commit();
        System.out.println("result = " + result);
    }

}
