package com.simpleboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.simpleboot.entity.User;
import com.simpleboot.mapper.SimpleUserMapper;
import com.simpleboot.service.SimpleUserService;
import com.simpleboot.utils.Result;
import com.simpleboot.utils.Sha1Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class SimpleUserServiceImpl implements SimpleUserService {

    @Autowired
    private SimpleUserMapper userMapper;

    @Override
    public User selectSimpleUserById(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public User selectSimpleUserByEmail(String email) {

        Wrapper<User> tWrapper = new QueryWrapper<User>().eq("user_email", email);
        return userMapper.selectOne(tWrapper);
    }

    @Override
    public List<User> selectSimpleUserList(User simpleUser) {
        return null;
    }

    @Override
    public Result insertSimpleUser(User simpleUser) {
        String userEmail = simpleUser.getUserEmail();
        String userName = simpleUser.getUserName();
        String userPassword = simpleUser.getUserPassword();
        if (userEmail == "" && userEmail == null && userEmail.equals("")) {
            return new Result().resultFailure("创建用户邮箱为空");
        }
        if (userName == "" && userName == null && userName.equals("")) {
            return new Result().resultFailure("创建用户姓名为空");
        }
        if (userPassword == "" && userPassword == null && userPassword.equals("")) {
            return new Result().resultFailure("创建用户密码为空");
        }
        simpleUser.setUserPassword(Sha1Util.inputPassFormPass(userPassword));

        simpleUser.setUserCreateTime(new Date());
        return new Result().resultSuccess("创建成功", userMapper.insert(simpleUser));
    }

    @Override
    public int updateSimpleUser(User simpleUser) {
        return 0;
    }

    @Override
    public int deleteSimpleUserById(Long userId) {
        return 0;
    }
}
