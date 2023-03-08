package com.simpleboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.simpleboot.entity.AuthEnum;
import com.simpleboot.entity.User;
import com.simpleboot.entity.UserDetail;
import com.simpleboot.entity.vo.Result;
import com.simpleboot.entity.vo.UserResult;
import com.simpleboot.mapper.SimpleUserMapper;
import com.simpleboot.service.SimpleUserService;
import com.simpleboot.utils.JwtUtil;
import com.simpleboot.utils.Sha1Util;
import com.simpleboot.utils.isValidUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SimpleUserServiceImpl implements SimpleUserService {

    @Autowired
    private SimpleUserMapper userMapper;

    @Override
    public UserDetail loginUser(String username) {
        Wrapper<User> tWrapper = new QueryWrapper<User>().eq("user_name", username);
        User user = userMapper.selectOne(tWrapper);
        List list = new ArrayList();
        list.add(AuthEnum.PRESENT_USER);
        UserDetail userDetail = new UserDetail(user, list);
        return userDetail;
    }

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
    public UserResult insertSimpleUser(User simpleUser) {
        String userName = simpleUser.getUserName();
        String userPassword = simpleUser.getUserPassword();
        if (StringUtils.isEmpty(userName)) {
            return UserResult.failure("创建用户邮箱为空");
        }
        if (isValidUtil.checkEmail(userName)) {
            return UserResult.failure("用户邮箱格式错误");
        }
        if (StringUtils.isEmpty(userPassword)) {
            return UserResult.failure("创建用户密码为空");
        }
        User user1 = this.selectSimpleUserByEmail(userName);
        if (user1 != null){
            return UserResult.failure("用户已存在");
        }
        simpleUser.setUserPassword(Sha1Util.inputPassFormPass(userPassword));
        simpleUser.setUserCreateTime(new Date());
        UserDetail userDetail = new UserDetail();
        return userMapper.insert(simpleUser) > 0 ? UserResult.success(this.selectSimpleUserByEmail(userName).getUserId(),null) : UserResult.failure("创建失败");
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
