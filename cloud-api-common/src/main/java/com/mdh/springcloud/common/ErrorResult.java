package com.mdh.springcloud.common;

import lombok.Data;

import java.lang.annotation.Annotation;

/**
 * @author madonghao
 * @create 2020-03-27 14:30
 **/
@Data
public class ErrorResult implements ResponseResult{

    private Integer code;
    private String message;
    private Object data;

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
