package com.hk.controller;

import com.hk.aspect.UserAspect;
import com.hk.dao.Result;
import com.hk.dao.User;
import com.hk.repository.UserRepository;
import com.hk.service.LoginService;
import com.hk.utils.ResultUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by hekai on 2018/1/22.
 */
@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    private LoginService loginService;

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping(value = "/login")
    public Result login(@RequestBody User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(bindingResult.getFieldError().getDefaultMessage(), 500);
        }
        User selectUser = userRepository.findByUserName(user.getUserName());
        if (selectUser == null) {
            return ResultUtils.error("用户不存在", 501) ;
        } else {
            if (selectUser.getPassword().equals(user.getPassword())) {
                return ResultUtils.success(null, "登录成功") ;
            } else {
                return ResultUtils.error("密码错误", 501) ;
            }
        }
    }
}
