package com.simpleboot.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResult implements Serializable {
    @JsonProperty("status_code")
    private Integer code;
    @JsonProperty("status_msg")
    private String msg;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("token")
    private String token;

    public static <T> UserResult success(String msg, Long userId, String token) {
        return new UserResult(200, msg, userId, token);
    }

    public static <T> UserResult success(Long userId, String token) {
        return new UserResult(200, "操作成功", userId, token);
    }


    public static <T> UserResult failure(String msg) {
        return new UserResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg,null,null);
    }

    public static <T> UserResult failure(Long userId) {
        return new UserResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "操作失败", userId,null);
    }

    public static <T> UserResult failure(Long userId,String token) {
        return new UserResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "操作失败", userId,token);
    }
}
