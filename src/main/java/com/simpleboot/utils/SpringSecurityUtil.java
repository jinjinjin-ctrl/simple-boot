package com.simpleboot.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

public class SpringSecurityUtil {

    /**
     * 登录
     * @param username 用户名
     * @param password  密码
     * @param authorities 权限
     */
    public static void login(String username,String password,List<String> authorities) {
        HttpServletRequest request = ((ServletRequestAttributes)
                (RequestContextHolder.currentRequestAttributes())).getRequest();
        List<GrantedAuthority> authList = AuthorityUtils.createAuthorityList(authorities.toArray(new String[]{}));
        UsernamePasswordAuthenticationToken token =new UsernamePasswordAuthenticationToken(username,password,authList);
        SecurityContextHolder.getContext().setAuthentication(token);
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,SecurityContextHolder.getContext());
    }

    /**
     * 获取当前登录名
     *
     * @return
     */
    public static String getLoginUserName(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    /**
     * 是否登录
     *
     * @return
     */
    public static boolean isLogin(){
        return !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
    }

}
