package com.mdh.springcloud.config;

import com.mdh.springcloud.common.CommonResult;
import com.mdh.springcloud.common.ErrorResult;
import com.mdh.springcloud.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author madonghao
 * @create 2020-03-27 14:16
 **/
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    //标记名称
    public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";

    //是否请求 包含了 包装注解 标记,没有就直接返回,不需要重写返回体
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = sra.getRequest();
        //判断请求 是否包装标记
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return responseResultAnn == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("进入 返回体 重写格式 处理中....");

//        if(body instanceof ErrorResult){
//            log.info("返回体 异常 做包装 处理中....");
//            ErrorResult errorResult = (ErrorResult) body;
//            return CommonResult.failure(errorResult.getCode(), errorResult.getMessage());
//        }
        return CommonResult.success(body);
    }

}
