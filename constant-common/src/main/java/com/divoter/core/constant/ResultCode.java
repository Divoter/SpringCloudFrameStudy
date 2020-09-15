package com.divoter.core.constant;

/**
 * @ClassName ResultCode
 * @Descripition 响应值枚举类
 * @Authour Divoter
 * @Date 2020/9/2 10:11
 * @Version 1.0
 */
public enum ResultCode {
    //--------code 200 +
    SUCCESS(200,"执行成功!")

    //--------code 400 +
    ,NOT_FOUND(404,"不存在！")

    //--------code 500 +
    ,INTERNAL_SERVER_ERROR(500,"服务器内部错误，请联系管理员！")

    //--------code 1000 +
    ,UNAUTHORIZED(1001,"未认证或未授权！")
    ,NO_TOKEN(1002,"没有接收到令牌！")
    ,ERR_TOKEN(1003,"令牌错误！")

    //--------code 2000 +
    ,FAIL(2000,"执行失败!")
    ,NO_ACCESS(2001,"没有权限！")
    ,REQ_TIMEOUT(2002,"请求超时！")
    ,REQ_PARAM_ERR(2003,"错误的参数！")


    ;
    private int value;
    private String code;
    private String message;

    ResultCode(int v,String msg) {
        this.value = v;
        this.code = ""+v;
        this.message = msg;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
