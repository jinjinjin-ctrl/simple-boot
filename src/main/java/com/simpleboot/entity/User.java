package com.simpleboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    @TableId(type = IdType.AUTO)
    private Long userId;

    /** 用户邮箱 */
    @TableField("user_email")
    private String userEmail;

    /** 用户姓名 */
    @TableField("user_name")
    private String userName;

    /** 用户密码 */
    @TableField("user_password")
    private String userPassword;

    /** 用户简介 */
    @TableField("user_follower_resume")
    private String userFollowerResume;

    /** 用户头像 */
    @TableField("user_avatar")
    private String userAvatar;

    /** 用户关注总数 */
    @TableField("user_follow_count")
    private Integer userFollowCount;

    /** 粉丝总数 */
    @TableField("user_follower_count")
    private Integer userFollowerCount;

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
