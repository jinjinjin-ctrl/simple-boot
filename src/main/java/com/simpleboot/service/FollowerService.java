package com.simpleboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simpleboot.entity.Follower;
import com.simpleboot.entity.vo.UserVO;

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
     * @param currentUserId 当前的用户Id
     * @return 用户列表(关注)
     */
    List<UserVO> follow(Integer userId, Integer currentUserId);

    /**
     * 用户粉丝列表
     * @param userId 查询的用户Id
     * @param currentUserId 当前的用户Id
     * @return 用户列表(粉丝)
     */
    List<UserVO> follower(Integer userId, Integer currentUserId);

    /**
     * 用户的好友列表
     * @param userId 查询的用户Id
     * @param currentUserId 当前的用户Id
     * @return 用户列表(好友)
     */
    List<UserVO> friend(Integer userId, Integer currentUserId);
}
