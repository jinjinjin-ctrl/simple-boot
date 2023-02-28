package com.simpleboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户粉丝
 * @author moli
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value ="simple_follower")
public class Follower implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 粉丝用户id
     */
    private Integer followerId;

    /**
     * 关注时间
     */
    private Date followerCreateTime;

    /**
     * 关注主播id
     */
    private Integer followerUserId;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}