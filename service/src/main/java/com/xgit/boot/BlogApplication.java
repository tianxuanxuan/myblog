package com.xgit.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by tianxuanxuan
 * On 2020-09-12 14:12
 */

@SpringBootApplication
@MapperScan("com.xgit.boot.mapper") //这里是个坑，如果不加mapperscan，bean初始化会加载不到mapper
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
