package com.simpleboot.service.impl;

import com.simpleboot.entity.SimpleVideo;
import com.simpleboot.entity.User;
import com.simpleboot.service.SimpleUserService;

import java.util.List;

public class SimpleUserServiceImpl implements SimpleUserService {

    @Override
    public SimpleVideo selectSimpleVideoById(Long userId) {
        return null;
    }

    @Override
    public List<SimpleVideo> selectSimpleUserList(User simpleUser) {
        return null;
    }

    @Override
    public int insertSimpleUser(User simpleUser) {
        return 0;
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
