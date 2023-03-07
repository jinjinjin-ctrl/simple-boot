package com.simpleboot.controller;

import com.simpleboot.entity.RelationAction;
import com.simpleboot.entity.vo.Result;
import com.simpleboot.service.MessageService;
import com.simpleboot.utils.TokenUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author moli
 */
@RestController
@Tag(name = "消息")
@RequiredArgsConstructor
@RequestMapping("message")
public class MessageController {
    private final TokenUtil tokenUtil;
    private final MessageService messageService;

    /**
     * 发送消息
     * @param toUserId 对方用户id
     * @param token 用户鉴权token
     * @param actionType 1-发送消息
     * @param content 消息内容
     * @return Result
     */
    @PostMapping("action")
    public Result<Void> action(@RequestParam("to_user_id")@NotEmpty String toUserId, @RequestParam@NotEmpty String token, @RequestParam("action_type")@NotEmpty String actionType, @RequestParam@NotEmpty String content){
        Integer currentUserId = tokenUtil.parser(token);
        if (!NumberUtils.INTEGER_ONE.toString().equals(actionType)) {
            throw new IllegalArgumentException();
        }
        messageService.action(currentUserId, Integer.valueOf(toUserId), content);
        return Result.success();
    }

    /**
     * 聊天记录
     * @param toUserId 对方用户id
     * @param token 用户鉴权token
     * @return Result message_list
     */
    @GetMapping("chat")
    public Result<List<RelationAction>> chat(@RequestParam("to_user_id")@NotEmpty String toUserId, @RequestParam@NotEmpty String token){
        Integer currentUserId = tokenUtil.parser(token);
        return Result.success(messageService.chat(currentUserId, Integer.valueOf(toUserId)));
    }
}
