package com.simpleboot.service.impl;

import com.simpleboot.entity.User;
import com.simpleboot.entity.UserDetail;
import com.simpleboot.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SimpleUserService userService;

    @Override
    public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectSimpleUserByEmail(username);
        if (user == null){
            throw new RuntimeException("用户不存在");
        }
        return new UserDetail(user,null);
    }
}
