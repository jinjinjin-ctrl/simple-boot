package com.simpleboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("simple_user")
public class User {
    private static final long serialVersionUID = 1L;

    /** 用户唯一标识 */
    @TableId
    private Long userId;

    /** 用户姓名 */
    @TableField("user_name")
    private String userName;

    /** 用户密码 */
    @TableField("user_password")
    private Long userPassword;

    /** 用户简介 */
    @TableField("user_follower_resume")
    private Long userFollowerResume;

    /** 用户头像 */
    @TableField("user_avatar")
    private Long userAvatar;

    /** 用户关注总数 */
    @TableField("user_follow_count")
    private Integer userFollowCount;

    /** 粉丝总数 */
    @TableField("user_follower_count")
    private String userFollowerCount;

    /** 是否关注 */
    @TableField("user_is_follow")
    private boolean userIsFollow;

    /** 创建时间 */
    @TableField("user_create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userCreateTime;

    /** 创建用户id */
    @TableField("user_create_id")
    private Long userCreateId;

    /** 修改时间 */
    @TableField("user_modify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userModifyTime;

    /** 修改用户id */
    @TableField("user_modify_id")
    private Long userModifyId;
}
