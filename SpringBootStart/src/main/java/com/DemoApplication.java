package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: HelloController
 * @date: 2020/4/25 15:47
 * @author: Finallap
 * @version: 1.0
 */
@MapperScan("com.mapper")
@RestController
@SpringBootApplication(exclude = {})
@EnableCaching
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30)
@EnableAspectJAutoProxy
public class DemoApplication {
    @GetMapping("show")
    public String test() {
        return "Hello Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
