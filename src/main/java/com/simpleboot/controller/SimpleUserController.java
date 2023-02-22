package com.simpleboot.controller;

import com.simpleboot.entity.Result;
import com.simpleboot.entity.User;
import com.simpleboot.service.SimpleUserService;
import com.simpleboot.utils.Sha1Util;
import com.simpleboot.utils.isValidUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class SimpleUserController {
    @Resource
    private SimpleUserService userService;

    @PostMapping("/login/")
    public Result loginUser(String username, String password){
        if (username == "" || username == null) {
            return new Result().failure("用户邮箱为空");
        }
        if (isValidUtil.checkEmail(username)) {
            return new Result().failure("用户邮箱格式错误");
        }
        if (password == "" || password == null) {
            return new Result().failure("用户密码为空");
        }
        User user = userService.selectSimpleUserByEmail(username);
        if (user.getUserName() == ""|| user.getUserName() == null){
            return new Result().failure("用户不存在");
        }
        if (!Sha1Util.inputPassFormPass(password).equals(user.getUserPassword())){
            return new Result().failure("用户密码错误");
        }
        System.out.println(user);
        return new Result().success("登录成功",user.getUserId());
    }


    @PostMapping("/register/")
    public Result createUser(String username, String password){
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);
        return userService.insertSimpleUser(user);
    }
}
