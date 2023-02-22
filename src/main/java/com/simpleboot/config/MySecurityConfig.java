package com.simpleboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Profile("prod")
@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/douyin/user/login").permitAll()
                .requestMatchers("/douyin/user/register/").permitAll()
                .requestMatchers("/static/**").permitAll()
                .anyRequest().authenticated()
                .and().build();
    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers(HttpMethod.POST, "/login").anonymous()
//                .requestMatchers(HttpMethod.POST, "/check").anonymous()
//                .requestMatchers(HttpMethod.GET, "/oauth/**").permitAll()
//                .requestMatchers("/logout").authenticated()
//                .requestMatchers("/admin/**").authenticated()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .cors(withDefaults())
//                .oauth2Login(withDefaults())
//                .build();
//    }


    @Bean
    protected WebSecurityCustomizer webSecurityCustomizer() {
        return WebSecurity::ignoring;
    }
}
