package com.simpleboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * TODO
 *
 * @author 27826
 * @version 1.0
 * @date 2021/4/12 22:54
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private T data;

    public static <T>Result <T>success(String msg, T t) {
        return new Result<T>(200, msg, t);
    }

    public static Result<Void> failure(String msg) {
        return new Result<>(300, msg, null);
    }
}
