package com.hk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hekai on 2018/1/22.
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login success";
    }
}
