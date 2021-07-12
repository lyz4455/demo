package com.example.demo;

import com.example.demo.learnlab.transactional.DemoMutithreadService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class DemoMutithreadApplicationTests {
    @Autowired
    DemoMutithreadService demoMutithreadService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() throws InterruptedException {
        demoMutithreadService.test1();
        Thread.sleep(200000);
    }

    @Test
    public void test2() throws InterruptedException {
        demoMutithreadService.test2();
        Thread.sleep(200000);
    }
}
