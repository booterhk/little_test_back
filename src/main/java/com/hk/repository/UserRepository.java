package com.hk.repository;

import com.hk.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hekai on 2018/1/24.
 *
 * note:
 * 1.仓库接口直接继承自 jpa的仓库，须指明实体及主键类型
 * 2.同时可以自己对接口进行扩展
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
     User findByUserName(String userName);
}
