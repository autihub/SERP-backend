package com.shanhai.serp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 山海雪冰 · 进销存系统 后端启动类。
 *
 * <p>统一接口前缀 /api（见 application.yml: server.servlet.context-path）。
 * Mapper 扫描 com.shanhai.serp.**.mapper。
 */
@SpringBootApplication
@MapperScan("com.shanhai.serp.**.mapper")
public class SerpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerpApplication.class, args);
    }
}
