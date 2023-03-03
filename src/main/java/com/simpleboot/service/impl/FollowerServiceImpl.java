package com.simpleboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simpleboot.entity.Follower;
import com.simpleboot.entity.User;
import com.simpleboot.entity.vo.UserVO;
import com.simpleboot.mapper.FollowerMapper;
import com.simpleboot.service.FollowerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author moli
*/
@Slf4j
@Service
@RequiredArgsConstructor
public class FollowerServiceImpl extends ServiceImpl<FollowerMapper, Follower> implements FollowerService {

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
    public List<UserVO> follow(Integer userId, Integer currentUserId) {
        List<User> userFollow = baseMapper.follow(userId);
        List<User> currentUserFollow = baseMapper.follow(currentUserId);
        return userFollow.stream().map(v->new UserVO(v, currentUserFollow.contains(v))).collect(Collectors.toList());
    }

    @Override
    public List<UserVO> follower(Integer userId, Integer currentUserId) {
        //用户的粉丝列表
        List<User> userFollower = baseMapper.follower(userId);
        //当前用户的关注列表
        List<User> currentUserFollow = baseMapper.follow(currentUserId);
        //如果粉丝列表中的是当前用户关注的用户则is_follow字段为true
        return userFollower.stream().map(v -> new UserVO(v, currentUserFollow.contains(v))).collect(Collectors.toList());
    }

    @Override
    public List<UserVO> friend(Integer userId, Integer currentUserId) {
        List<User> follower = baseMapper.follower(userId);
        List<User> follow = baseMapper.follow(userId);
        List<User> intersection = follow.stream().filter(follower::contains).toList();
        List<User> currentFollow = baseMapper.follow(currentUserId);
        return intersection.stream().map(v->new UserVO(v, currentFollow.contains(v))).toList();
    }


}




