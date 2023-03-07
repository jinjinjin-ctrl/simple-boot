package com.simpleboot.controller;

import com.simpleboot.entity.User;
import com.simpleboot.entity.UserDetail;
import com.simpleboot.entity.vo.Result;
import com.simpleboot.entity.vo.UserResult;
import com.simpleboot.service.SimpleUserService;
import com.simpleboot.utils.JwtUtil;
import com.simpleboot.utils.Sha1Util;
import com.simpleboot.utils.isValidUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class SimpleUserController {
    @Resource
    private SimpleUserService userService;




    @GetMapping("/")
    public Result getUser(Long user_id, String token) {
        System.out.println(token);
        User user = userService.selectSimpleUserById(user_id);
        return Result.success("用户信息", user);
    }

    @PostMapping("/login/")
    public UserResult loginUser(String username, String password) {
        if (username == "" || username == null) {
            return new UserResult().failure("用户邮箱为空");
        }
        if (isValidUtil.checkEmail(username)) {
            return new UserResult().failure("用户邮箱格式错误");
        }
        if (password == "" || password == null) {
            return new UserResult().failure("用户密码为空");
        }
        UserDetail user = userService.loginUser(username);
        System.out.println("user = " + user);
        if (user == null) {
            return new UserResult().failure("用户不存在");
        }
        if (Sha1Util.matchesPassword(password,user.getPassword())) {
            return new UserResult().failure("用户密码错误");
        }
        System.out.println(user);
        return new UserResult().success("登录成功", user.getUserId(), JwtUtil.createtoken(user));
    }


    @PostMapping("/register/")
    public Result createUser(String username, String password) {
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);
        return userService.insertSimpleUser(user);
    }
}
