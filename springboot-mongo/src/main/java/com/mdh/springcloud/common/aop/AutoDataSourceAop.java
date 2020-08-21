package com.mdh.springcloud.common.aop;

import com.mdh.springcloud.common.annotation.DataSourceSelection;
import com.mdh.springcloud.common.config.DynamicDataSourceHandler;
import com.mdh.springcloud.common.constant.DateSourceKey;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author madonghao
 * @create 2020-08-20 19:51
 **/
@Aspect
@Component
@Log4j2
public class AutoDataSourceAop {
    @Pointcut("@annotation(com.mdh.springcloud.common.annotation.DataSourceSelection)")
    public void dataSourceSelection() {

    }

    @Before("dataSourceSelection()")
    public void around(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        DataSourceSelection dataSourceSelection = method.getAnnotation(DataSourceSelection.class);
        if (null != dataSourceSelection) {
            DateSourceKey dataSourceKey = dataSourceSelection.value();
            if (DynamicDataSourceHandler.containDataSourceKey(dataSourceKey.getKey())) {
                DynamicDataSourceHandler.clearDataSourceKey();
            }
            DynamicDataSourceHandler.setDataSourceKey(dataSourceKey.getKey());
        }


    }
}
