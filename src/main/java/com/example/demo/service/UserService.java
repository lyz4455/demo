package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/23 15:01
 */

public interface UserService {

    User getUser(int id);

    List<User> getUsers();

    Integer insertUser(User user);
}
