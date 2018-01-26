package com.hk.controller;

import com.hk.dao.Result;
import com.hk.dao.User;
import com.hk.repository.UserRepository;
import com.hk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hekai on 2018/1/24.
 * note:
 *  1.控制器主要是对访问进行控制的
 *  2.其中可以引入仓库 repository ,服务 service
 *  3.参数控制有两种参数（路径参数，请求体参数）,对于put和 post 两种方式，应该采用对象来获取参数
 *  4.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // 获取全部用户
    @GetMapping(value = "/getUsers")
    public List<User> userList() {
        return userRepository.findAll();
    }

    // 新增用户
    @PostMapping(value = "/addUser")
    public Result<User> addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Result result = new Result();
            result.setStatusCode(500);
            result.setMessage("创建失败");
            result.setData(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword());
        user.setAge(user.getAge());

        Result result = new Result();
        result.setStatusCode(200);
        result.setMessage("创建成功");
        result.setData(userRepository.save(user));
        return result;
    }

    //同时新增两个用户
    @PostMapping(value = "/insertTwoUsers")
    public void insertTwoUsers(){
        userService.insertTwoUsers();
    }

    // 查询单个用户
    @GetMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }

    //根据名字查询用户
    @GetMapping(value = "/getUserByUserName/{userName}")
    public User getUserByUserName(@PathVariable("userName") String userName) {
        return userRepository.findByUserName(userName);
    }

    // 更新用户信息
    @PutMapping(value = "updateUser/{id}")
    public User updateUser(User user) {
        user.setId(user.getId());
        user.setUserName(user.getUserName());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    // 删除用户
    @DeleteMapping(value = "deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.delete(id);
    }
}
