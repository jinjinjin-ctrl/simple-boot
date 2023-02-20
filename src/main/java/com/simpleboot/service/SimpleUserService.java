package com.simpleboot.service;

import com.simpleboot.entity.SimpleVideo;
import com.simpleboot.entity.User;

import java.util.List;

public interface SimpleUserService {

    /**
     * 查询用户
     *
     * @param userId 用户ID
     * @return 视频
     */
    public SimpleVideo selectSimpleVideoById(Long userId);

    /**
     * 查询用户列表
     *
     * @param simpleUser 用户
     * @return 用户集合
     */
    public List<SimpleVideo> selectSimpleUserList(User simpleUser);

    /**
     * 创建用户
     *
     * @param simpleUser 用户
     * @return 结果
     */
    public int insertSimpleUser(User simpleUser);

    /**
     * 修改视频
     *
     * @param simpleUser 用户
     * @return 结果
     */
    public int updateSimpleUser(User simpleUser);

    /**
     * 删除用户
     *
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteSimpleUserById(Long userId);


}
