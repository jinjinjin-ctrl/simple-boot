package com.simpleboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simpleboot.entity.RelationAction;
import com.simpleboot.mapper.MessageMapper;
import com.simpleboot.service.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
* @author moli
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, RelationAction> implements MessageService {

    @Override
    public void action(Integer fromUserId, Integer toUserId, String content) {
        save(RelationAction.builder()
                .rActionFromUserId(fromUserId)
                .rActionToUserId(toUserId)
                .rActionContent(content)
                .rActionCreateTime(LocalDateTime.now())
                .build());
    }

    @Override
    public List<RelationAction> chat(Integer fromUserid, Integer toUserId) {
        return list(new LambdaQueryWrapper<RelationAction>()
                .eq(RelationAction::getRActionFromUserId, fromUserid)
                .eq(RelationAction::getRActionToUserId, toUserId)
                .orderByDesc(RelationAction::getRActionCreateTime));
    }
}




