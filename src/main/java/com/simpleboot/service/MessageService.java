package com.simpleboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.simpleboot.entity.RelationAction;

import java.util.List;

/**
* @author moli
*/
public interface MessageService extends IService<RelationAction> {

    /**
     * 发送聊天
     * @param fromUserId 发送的用户
     * @param toUserId 接收的用户
     * @param content 发送的内容
     */
    void action(Integer fromUserId, Integer toUserId, String content);

    /**
     * 聊天历史
     * @param fromUserid 查询的用户
     * @param toUserId 接收的用户
     * @return 聊天历史列表
     */
    List<RelationAction> chat(Integer fromUserid, Integer toUserId);
}
