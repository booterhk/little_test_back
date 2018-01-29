package com.hk.utils;

import com.hk.dao.Result;

/**
 * Created by hekai on 2018/1/28.
 */
public class ResultUtils {
    public static Result success(Object object, String message) {
        Result result =new Result();
        result.setStatusCode(200);
        result.setMessage(message);
        result.setData(object);
        return result;
    }

    public static Result success () {
        return null;
    }

    public static Result error (String message, Integer statusCode) {
        Result result =new Result();
        result.setStatusCode(statusCode);
        result.setMessage(message);
        return result;
    }
}
