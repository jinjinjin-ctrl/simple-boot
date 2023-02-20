package com.simpleboot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @author 27826
 * @version 1.0
 * @date 2021/4/12 22:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer count;
    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result resultSuccess(String msg,T t){
        return new Result(200,msg,t);
    }
    public Result resultFailure(String msg){
        return new Result(300,msg,"");
    }
}
