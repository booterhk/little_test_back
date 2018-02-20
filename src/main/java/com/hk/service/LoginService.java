package com.hk.service;

import com.hk.Exception.UserException;
import com.hk.dao.User;
import com.hk.repository.UserRepository;
import com.hk.utils.ResultUtils;
import org.springframework.stereotype.Service;

/**
 * Created by hekai on 2018/2/5.
 */
@Service
public class LoginService {

    private UserRepository userRepository;

    public User getUser(String userName, String password) throws Exception{
        User user = userRepository.findByUserName(userName);
        if (user.equals(null)) {
            throw new UserException(501, " 查无此人");
        } else if (!user.getPassword().equals(password)) {
            throw new UserException(500, "密码错误");
        }
        return user;
    }
}
