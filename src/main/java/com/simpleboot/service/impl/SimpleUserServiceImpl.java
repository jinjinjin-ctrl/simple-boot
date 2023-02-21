package com.simpleboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.simpleboot.entity.Result;
import com.simpleboot.entity.User;
import com.simpleboot.mapper.SimpleUserMapper;
import com.simpleboot.service.SimpleUserService;
import com.simpleboot.utils.Sha1Util;
import com.simpleboot.utils.isValidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SimpleUserServiceImpl implements SimpleUserService {

    @Autowired
    private SimpleUserMapper userMapper;

    @Override
    public User selectSimpleUserById(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public User selectSimpleUserByEmail(String username) {
        Wrapper<User> tWrapper = new QueryWrapper<User>().eq("user_name", username);
        return userMapper.selectOne(tWrapper);
    }

    @Override
    public List<User> selectSimpleUserList(User simpleUser) {
        return null;
    }

    @Override
    public Result<Void> insertSimpleUser(User simpleUser) {
        String userName = simpleUser.getUserName();
        String userPassword = simpleUser.getUserPassword();
        if (userName == "" || userName == null) {
            return Result.failure("创建用户邮箱为空");
        }
        if (isValidUtil.checkEmail(userName)) {
            return new Result().failure("用户邮箱格式错误");
        }
        if (userPassword == "" || userPassword == null) {
            return Result.failure("创建用户密码为空");
        }
        simpleUser.setUserPassword(Sha1Util.inputPassFormPass(userPassword));
        simpleUser.setUserCreateTime(new Date());
        return userMapper.insert(simpleUser) > 0 ? Result.success() : Result.failure("创建失败");
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
