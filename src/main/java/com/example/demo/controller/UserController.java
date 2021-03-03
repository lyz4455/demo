package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.domain.entity.QueryPages;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/23 15:00
 */
@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/getUsers")
    public List<User> getUsers(@RequestBody QueryPages queryPages) {
        //pageNum:表示第几页  pageSize:表示一页展示的数据
        int pageNum = queryPages.getPageNum();
        int pageSize = queryPages.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.getUsers();
        //将查询到的数据封装到PageInfo对象
        PageInfo<User> pageInfo = new PageInfo(list);
        //分割数据成功
        return list;
    }

    @PostMapping("/createUser")
    public Integer createUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

}
