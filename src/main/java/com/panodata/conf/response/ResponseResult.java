package com.panodata.conf.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by wp_sp on 2017/3/24.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult<T> {
    private boolean success;
    private String message;
    private T result;
    /* 不提供直接设置errorCode的接口，只能通过setErrorInfo方法设置错误信息 */
    private String Code;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setErrorInfo(ResponseErrorEnum responseErrorEnum) {
        this.Code = responseErrorEnum.getIndex();
        this.message = responseErrorEnum.getName();
        setCode(Code);
        setMessage(message);
    }
}