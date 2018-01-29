package com.hk.Exception;

/**
 * Created by hekai on 2018/1/29.
 */
public class UserException extends RuntimeException{
    private Integer statusCode;

    public UserException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
