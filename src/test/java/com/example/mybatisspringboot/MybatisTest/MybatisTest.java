package com.example.mybatisspringboot.MybatisTest;

import com.example.mybatisspringboot.mapper.UserMapper;
import com.example.mybatisspringboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: mybatis-springboot
 * @Package: com.example.mybatisspringboot.MybatisTest
 * @ClassName: MybatisTest
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/11/9 15:53
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test_insert(){
        User build = User.builder().userName("5555555555555").passWord("55555555").build();
        userMapper.insert(build);
    }
}
