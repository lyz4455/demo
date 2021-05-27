package com.example.demo.test.transactional.handler;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AsyncService {
    @Autowired
    UserMapper userMapper;

    @Async
    @Transactional
    public void test2(Integer i){
        User user = new User();
        user.setCreateTime(LocalDateTime.now());
        user.setName("testS1");
        userMapper.insert(user);
        System.out.println("子线程执行完成");
        if (i == 2) {
            int b = 1 /0;
        }
    }

}
