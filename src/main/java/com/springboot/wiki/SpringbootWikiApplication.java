package com.springboot.wiki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.springboot.wiki.mapper")
public class SpringbootWikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWikiApplication.class, args);
    }

}
