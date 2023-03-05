package com.simpleboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户聊天
 * @author moli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value ="simple_relation_action")
public class RelationAction implements Serializable {
    /**
     * 消息id
     */
    @TableId(type = IdType.AUTO)
    private Long rActionId;

    /**
     * 消息内容
     */
    private String rActionContent;

    /**
     * 消息发送日期
     */
    private LocalDateTime rActionCreateTime;

    /**
     * 发送用户id
     */
    private Integer rActionFromUserId;

    /**
     * 接收用户id
     */
    private Integer rActionToUserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}