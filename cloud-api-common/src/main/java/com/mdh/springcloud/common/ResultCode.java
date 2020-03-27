package com.mdh.springcloud.common;

/**
 * @author madonghao
 * @create 2020-03-27 11:20
 **/
public enum ResultCode {

    // http状态码
    //100-199  信息,服务器接收到请求,需要请求者继续执行操作
    //200-299  成功,操作被成功接收并处理   200:请求成功
    //300-399  重定向,需要进一步的操作以完成请求   301:资源（网页等）被永久转移到其它URL
    //400-499  客户端错误,请求包含语法错误或无法完成请求  404:请求的资源（网页等）不存在
    //500-599  服务器错误,服务器在处理请求的过程中发生了错误  500:内部服务器错误

    // 设计成
    //#1000～1999 区间表示参数错误
    //#2000～2999 区间表示用户错误
    //#3000～3999 区间表示接口异常

    //成功状态码
    SUCCESS(1, "成功"),
    //参数错误 1001-1999
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(1003, "参数类型错误"),
    //用户错误 2001-2999
    USER_NOT_LOGGED_IN(2001, "用户未登录,访问的路径需要验证,请登录"),
    USER_LOGIN_ERROR(2002, "账号不存在或密码错误");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
