package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.config.CustomBaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyz4455
 * @since 2020-06-23
 */
public interface UserMapper extends CustomBaseMapper<User> {

    User getUser(int id);

    List<User> getUsers();

}
