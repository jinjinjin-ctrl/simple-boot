package com.simpleboot.controller;

import com.simpleboot.service.SimpleUserService;
import com.simpleboot.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/douyin/user")
public class SimpleUserController {

    private SimpleUserService userService;

    @RequestMapping("/login")
    public Result loginUser(String email,String password){


        return new Result().resultSuccess("登录成功",1);
    }


    @PostMapping("/register/")
    public Result createUser(String username,String password){
        if (username == "" && username == null ) {
            return new Result().resultFailure("创建用户邮箱为空");
        }
        if (password == "" && password == null) {
            return new Result().resultFailure("创建用户密码为空");
        }

        return new Result().resultSuccess("登录成功",1);
    }
}
