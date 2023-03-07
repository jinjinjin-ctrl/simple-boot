package com.simpleboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.simpleboot.mapper")
@EnableMethodSecurity(securedEnabled = true,jsr250Enabled = true)
public class SimpleBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleBootApplication.class, args);
    }

}
