package com.simpleboot.controller;

import com.simpleboot.entity.Result;
import com.simpleboot.entity.User;
import com.simpleboot.entity.param.RelationActionParam;
import com.simpleboot.entity.param.UserParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "社交")
@RestController
@RequestMapping("relation")
public class RelationController {

    @PostMapping("action")
    public Result<Void> relationAction(@RequestParam(required = false) RelationActionParam relationActionParam){
        return Result.success();
    }

    @GetMapping("follow/list")
    public Result<List<User>> follow(@RequestParam(required = false) UserParam userParam){
        return Result.success();
    }

    @GetMapping("follower/list")
    public Result<List<User>> follower(@RequestParam(required = false) UserParam userParam){
        return Result.success();
    }

    @GetMapping("friend/list")
    public Result<List<User>> friend(@RequestParam(required = false) UserParam userParam){
        return Result.success();
    }
}
