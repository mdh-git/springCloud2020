package com.mdh.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 返回结果工具类
 * @author madonghao
 * @create 2020-03-21 13:00
 *
 * https://mp.weixin.qq.com/s/aBxMHz8-qGjzRz-TLKr6Yw
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public CommonResult(ResultCode resultCode, T data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.data = data;
    }

    public static CommonResult success(){
        CommonResult result = new CommonResult();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMessage());
        return result;
    }

    public static CommonResult success(Object data){
        CommonResult result = new CommonResult();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static CommonResult failure(ResultCode code){
        CommonResult result = new CommonResult();
        result.setCode(code.getCode());
        result.setMsg(code.getMessage());
        return result;
    }

    public static CommonResult failure(Integer code, String msg){
        CommonResult result = new CommonResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static CommonResult failure(ResultCode code, Object data){
        CommonResult result = new CommonResult();
        result.setCode(code.getCode());
        result.setMsg(code.getMessage());
        result.setData(data);
        return result;
    }
}
