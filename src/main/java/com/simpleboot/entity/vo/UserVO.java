package com.simpleboot.entity.vo;

import com.simpleboot.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author moli
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends User {
    private Boolean isFollow;

    public UserVO(User user, Boolean isFollow) {
        this.isFollow = isFollow;
        setUserId(user.getUserId());
        setUserEmail(user.getUserEmail());
        setUserName(user.getUserName());
        setUserPassword(user.getUserPassword());
        setUserFollowerResume(user.getUserFollowerResume());
        setUserAvatar(user.getUserAvatar());
        setUserFollowCount(user.getUserFollowCount());
        setUserFollowerCount(user.getUserFollowerCount());
        setUserCreateTime(user.getUserCreateTime());
        setUserCreateId(user.getUserCreateId());
        setUserModifyTime(user.getUserModifyTime());
        setUserModifyId(user.getUserModifyId());
    }
}
