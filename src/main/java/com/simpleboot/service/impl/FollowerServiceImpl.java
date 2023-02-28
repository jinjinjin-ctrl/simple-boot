package com.simpleboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simpleboot.entity.Follower;
import com.simpleboot.entity.User;
import com.simpleboot.mapper.FollowerMapper;
import com.simpleboot.service.FollowerService;
import com.simpleboot.service.SimpleUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author moli
*/
@Slf4j
@Service
@RequiredArgsConstructor
public class FollowerServiceImpl extends ServiceImpl<FollowerMapper, Follower> implements FollowerService {
    private final SimpleUserService simpleUserService;

    @Override
    public void relationAction(Integer formUserId, String toUserId, int actionType) {
        Follower follower = Follower.builder()
                .followerId(formUserId)
                .followerUserId(Integer.valueOf(toUserId))
                .followerCreateTime(new Date()).build();
        if (actionType == 1) {
            save(follower);
        }
        if (actionType == 2) {
            remove(new QueryWrapper<>(follower));
        }
        log.error("relationActionError; actionType: " + actionType);
    }

    @Override
    public List<User> follow(String userId) {
        //TODO User关注状态
        return baseMapper.follow(userId);
    }

    @Override
    public List<User> follower(String userId) {
        //TODO User关注状态
        return baseMapper.follower(userId);
    }

    @Override
    public List<User> friend(String userId) {
        //TODO User关注状态
        return baseMapper.friend(userId);
    }


}




