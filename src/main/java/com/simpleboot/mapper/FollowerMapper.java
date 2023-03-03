package com.simpleboot.mapper;

import com.simpleboot.entity.Follower;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simpleboot.entity.User;

import java.util.List;

/**
* @author moli
*/
public interface FollowerMapper extends BaseMapper<Follower> {

    /**
     * 关注用户列表
     * @param userId 查询的用户Id
     * @return 用户列表(关注)
     */
    List<User> follow(Integer userId);

    /**
     * 用户粉丝列表
     * @param userId 查询的用户Id
     * @return 用户列表(粉丝)
     */
    List<User> follower(Integer userId);

}




