package com.simpleboot.service;

import com.simpleboot.entity.Result;
import com.simpleboot.entity.User;

import java.util.List;

public interface SimpleUserService {

    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return 视频
     */
    User selectSimpleUserById(Long userId);

    /**
     * 查询用户
     *
     * @param username 用户邮箱
     * @return 视频
     */
    User selectSimpleUserByEmail(String username);
    /**
     * 查询用户列表
     *
     * @param simpleUser 用户
     * @return 用户集合
     */
    List<User> selectSimpleUserList(User simpleUser);

    /**
     * 创建用户
     *
     * @param simpleUser 用户
     * @return 结果
     */
    Result<Void> insertSimpleUser(User simpleUser);

    /**
     * 修改视频
     *
     * @param simpleUser 用户
     * @return 结果
     */
    int updateSimpleUser(User simpleUser);

    /**
     * 删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    int deleteSimpleUserById(Long userId);
}
