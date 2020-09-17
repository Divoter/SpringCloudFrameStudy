package com.divoter.core;

import com.divoter.core.constant.ResultCode;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }
    public static Result genFailResult(ResultCode resultCode) {
        return new Result()
                .setCode(resultCode.getCode())
                .setMessage(resultCode.getMessage()).setSuccess(false);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL.getCode())
                .setMessage(message).setSuccess(false);
    }
    public static Result genParamErrorResult(String message) {
        return new Result()
                .setCode(ResultCode.REQ_PARAM_ERR.getCode())
                .setMessage(message).setSuccess(false);
    }
}
