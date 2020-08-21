package com.mdh.springcloud.common.annotation;

import com.mdh.springcloud.common.constant.DateSourceKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 数据源选取
 *
 * @author madonghao
 * @create 2020-08-20 19:48
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceSelection {
    /**
     * 数据源名称
     *
     * @return
     */
    DateSourceKey value();
}
