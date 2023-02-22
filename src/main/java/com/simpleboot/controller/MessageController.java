package com.simpleboot.controller;

import com.simpleboot.entity.Result;
import com.simpleboot.entity.param.UserParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "消息")
@RequestMapping("message")
public class MessageController {

    @PostMapping("action")
    public Result<Void> action(UserParam userParam){
        return Result.success();
    }

    @GetMapping("chat")
    public Result<List<Message>> chat(UserParam userParam){
        return Result.success();
    }
}
