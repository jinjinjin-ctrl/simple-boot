package com.simpleboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(
                authz-> {
                    try {
                        authz.requestMatchers("/douyin/user/login","/douyin/user/register").permitAll()
                                .requestMatchers("/static/**").permitAll()
                                .anyRequest().authenticated().and().csrf(csrf->csrf.disable());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    protected WebSecurityCustomizer webSecurityCustomizer() {
        return WebSecurity::ignoring;
    }
}
