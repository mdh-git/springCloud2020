package com.mdh.springcloud.common;

import java.lang.annotation.*;

/**
 * 注解类
 * 用来标记方法的返回值，是否需要包装
 * @author madonghao
 * @create 2020-03-27 13:29
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
