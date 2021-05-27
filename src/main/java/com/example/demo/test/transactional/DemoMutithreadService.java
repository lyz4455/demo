package com.example.demo.test.transactional;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.test.transactional.handler.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(rollbackFor = Exception.class)
public class DemoMutithreadService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    AsyncService asyncService;

    @Transactional
    public void test1() throws InterruptedException {
        User user = new User();
        user.setCreateTime(LocalDateTime.now());
        user.setName("testM1");
        userMapper.insert(user);
        System.out.println("主线程执行完成");
        //断点打在这,看主线程执行完事务是否提交
        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            @Transactional
            public void run() {
                user.setCreateTime(LocalDateTime.now());
                user.setName("testS1");
                userMapper.insert(user);
                System.out.println("子线程执行完成");
                int i = 1 / 0;
            }
        }).start();
    }

    @Transactional
    public void test2() throws InterruptedException {
        User user = new User();
        user.setCreateTime(LocalDateTime.now());
        user.setName("testM1");
        userMapper.insert(user);
        System.out.println("主线程执行完成");
        //断点打在这,看主线程执行完事务是否提交
        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {
            asyncService.test2(i);
        }
//        int i = 1 / 0;
        Thread.sleep(2000);
    }
}
