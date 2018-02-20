package com.hk.handle;

import com.hk.Exception.UserException;
import com.hk.controller.LoginController;
import com.hk.dao.Result;
import com.hk.utils.ResultUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hekai on 2018/1/29.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result userExceptionHandle(Exception e) {
        logger.info(e.toString());
        if (e instanceof UserException) {
            logger.info(e.toString());
            UserException userException = (UserException) e;
            return ResultUtils.error(userException.getMessage(), userException.getStatusCode());
        } else {
            return ResultUtils.error("userExceptionHandle 未知错误", -1);
        }
    }
}
