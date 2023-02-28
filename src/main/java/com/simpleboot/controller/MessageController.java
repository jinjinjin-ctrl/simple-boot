package com.simpleboot.controller;

import com.simpleboot.entity.Result;
import com.simpleboot.utils.TokenUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.Message;
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

    @PostMapping("action")
    public Result<Void> action(@RequestParam("user_id") String userId,@RequestParam String token){
        return Result.success();
    }

    @GetMapping("chat")
    public Result<List<Message>> chat(@RequestParam("user_id") String userId,@RequestParam String token){
        return Result.success();
    }
}
