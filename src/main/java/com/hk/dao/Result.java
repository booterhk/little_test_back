package com.hk.dao;



/**
 * Created by hekai on 2018/1/26.
 * http 请求最外层封装
 */
public class Result<T> {

    /**
     * 状态码
     */
    private Integer statusCode;

    /**
     * Msg
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
