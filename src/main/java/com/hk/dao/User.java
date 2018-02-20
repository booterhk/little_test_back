package com.hk.dao;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by hekai on 2018/1/22.
 * note:
 * 1.实体类中定义实体应加入@Entity,同时对于主键，自增，限定重复等也有定义
 * 2.jpa实体类中需增加空构造，具体原因不详
 * 3.右键可快速set,get
 */
@Entity
@Table(name = "user")
public class User {
    //主键 ID
    @Id
    @GeneratedValue
    private Integer id;
    //用户名
    @NotBlank(message = "用户名不能为空")
    private String userName;
    //密码
    @NotBlank(message = "密码不能为空")
    private String password;
    // 年龄
    @Min(value = 13, message = "年龄太小")
    private Integer age;

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
