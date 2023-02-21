package com.simpleboot.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

/**
 * TODO
 *
 * @author 27826
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @JsonProperty("status_code")
    private Integer code;
    @JsonProperty("status_msg")
    private String msg;
    private T data;


    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T>Result <T> success(String msg, T data) {
        return new Result<>(200, msg, data);
    }

    public static <T>Result <T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }

    public static <T>Result <T> success() {
        return new Result<>(200, "操作成功", null);
    }

    public static <T> Result<T> failure(String msg) {
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static <T> Result<T> failure(T data) {
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "操作失败", data);
    }

    public static <T> Result<T> failure(String msg, T data) {
        return new Result<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
    }

    public static <T> Result<T> failure(int code, String msg) {
        return new Result<>(code, msg);
    }
}
