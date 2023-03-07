package com.simpleboot.controller;

import com.simpleboot.entity.vo.Result;
import com.simpleboot.entity.vo.UserVO;
import com.simpleboot.service.FollowerService;
import com.simpleboot.utils.TokenUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author moli
 */
@Tag(name = "社交")
@RestController
@RequiredArgsConstructor
@RequestMapping("relation")
public class RelationController {
    private final FollowerService followerService;
    private final TokenUtil tokenUtil;

    /**
     * 关注操作
     * @param toUserId 对方用户id
     * @param actionType 1-关注，2-取消关注
     * @param token 用户鉴权token
     * @return Result
     */
    @PostMapping("action")
    public Result<Void> relationAction(@RequestParam("to_user_id") String toUserId,
                                       @RequestParam("action_type") String actionType,
                                       @RequestParam("token") String token) {
        Integer formUserId = tokenUtil.parser(token);
        followerService.relationAction(formUserId, toUserId, Integer.parseInt(actionType));
        return Result.success();
    }

    /**
     * 关注列表
     * @param userId 用户Id
     * @param token 鉴权token
     * @return 关注的用户列表
     */
    @GetMapping("follow/list")
    public Result<List<UserVO>> follow(@RequestParam("user_id") String userId, @RequestParam String token) {
        Integer currentUserId = tokenUtil.parser(token);
        return Result.success(followerService.follow(Integer.valueOf(userId), currentUserId));
    }

    /**
     * 粉丝列表
     * @param userId 用户Id
     * @param token 鉴权token
     * @return 粉丝的用户列表
     */
    @GetMapping("follower/list")
    public Result<List<UserVO>> follower(@RequestParam("user_id") String userId, @RequestParam String token) {
        Integer currentUserId = tokenUtil.parser(token);
        return Result.success(followerService.follower(Integer.valueOf(userId), currentUserId));
    }

    @GetMapping("friend/list")
    public Result<List<UserVO>> friend(@RequestParam("user_id") String userId, @RequestParam String token) {
        Integer currentUserId = tokenUtil.parser(token);
        return Result.success(followerService.friend(Integer.valueOf(userId), currentUserId));
    }
}
