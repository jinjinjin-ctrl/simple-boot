package com.simpleboot.controller;

import com.simpleboot.entity.Result;
import com.simpleboot.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "社交")
@RestController
@RequestMapping("relation")
public class RelationController {

    @PostMapping("action")
    public Result<Void> relationAction(@RequestParam("to_user_id") String toUserId,@RequestParam("action_type") String actionType,@RequestParam("token") String token){
        return Result.success();
    }

    @GetMapping("follow/list")
    public Result<List<User>> follow(@RequestParam("user_id") String userId,@RequestParam String token){
        return Result.success();
    }

    @GetMapping("follower/list")
    public Result<List<User>> follower(@RequestParam("user_id") String userId,@RequestParam String token){
        return Result.success();
    }

    @GetMapping("friend/list")
    public Result<List<User>> friend(@RequestParam("user_id") String userId,@RequestParam String token){
        return Result.success();
    }
}
