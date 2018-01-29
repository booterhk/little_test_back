package com.hk.service;

import com.hk.Exception.UserException;
import com.hk.dao.User;
import com.hk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by hekai on 2018/1/24.
 * note:
 * 1.服务主要针对于业务逻辑来说，可以根据业务需求对服务进行定制化
 * 2.服务中事务控制对于增、删、改来说是必须的，查询则不必要
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void insertTwoUsers() {
        User user1 = new User();
        user1.setUserName("hk");
        userRepository.save(user1);

        User user2 = new User();
        user2.setUserName("hk1");
        userRepository.save(user2);
    }

    public User getAge(Integer id) throws Exception{
        User user = userRepository.findOne(id);
        Integer age = user.getAge();
        if (age < 10) {
            throw new UserException(501, "年龄太小");
        } else if (age <16) {
            throw new UserException(500, "还是太小");
        }
        return user;
    }
}
