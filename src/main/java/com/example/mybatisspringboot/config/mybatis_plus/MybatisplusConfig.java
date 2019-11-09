package com.example.mybatisspringboot.config.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ProjectName: mybatis-springboot
 * @Package: com.example.mybatisspringboot.config.mybatis_plus
 * @ClassName: MybatisplusConfig
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/11/9 15:18
 * @Version: 1.0
 */
@Configuration
@MapperScan("com.example.mybatisspringboot.mapper")
@EnableTransactionManagement
public class MybatisplusConfig {

 /**
 * mybatis-plus分页插件<br>
 * 文档：https://mp.baomidou.com/guide/page.html <br>
 */

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
