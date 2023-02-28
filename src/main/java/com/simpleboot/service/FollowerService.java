package com.simpleboot.service;

import com.simpleboot.entity.Follower;
import com.baomidou.mybatisplus.extension.service.IService;
import com.simpleboot.entity.User;

import java.util.List;

/**
* @author moli
*/
public interface FollowerService extends IService<Follower> {

    /**
     * 关注操作
     * @param formUserId 操作的用户Id
     * @param toUserId 对方用户id
     * @param actionType 1-关注，2-取消关注
     */
    void relationAction(Integer formUserId, String toUserId, int actionType);

    /**
     * 关注用户列表
     * @param userId 查询的用户Id
     * @return 用户列表(关注)
     */
    List<User> follow(String userId);

    /**
     * 用户粉丝列表
     * @param userId 查询的用户Id
     * @return 用户列表(粉丝)
     */
    List<User> follower(String userId);

    /**
     * 用户的好友列表
     * @param userId 用户Id
     * @return 用户列表(好友)
     */
    List<User> friend(String userId);
}
