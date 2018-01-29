package com.hk.handle;

import com.hk.Exception.UserException;
import com.hk.dao.Result;
import com.hk.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hekai on 2018/1/29.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result userExceptionHandle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultUtils.error(userException.getMessage(), userException.getStatusCode());
        } else {
            return ResultUtils.error("未知错误", -1);
        }
    }
}
