package com.cat.cat.controller;


import com.cat.cat.entity.User;
import com.cat.cat.mapper.UserMapper;
import com.cat.cat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    // 新增和修改
    @PostMapping
    public int save(@RequestBody User user) {
        // 新增或者更新
        return userService.save(user);
    }

    // 查询所有数据
    @GetMapping
    public List<User> findAll() {
        List<User> all = userMapper.findAll();
        return all;
    }

    //分页查询
    //接口路径： /user/page?/pageNum=1&pageSize=10
    //@RequestParam 接收路径上面的pageNum以及pageSize
    //limit实现分页查询
    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        int count = userMapper.findCount();
        pageNum = (pageNum - 1)*pageSize;
        Map<String,Object> res = new HashMap<>();
        List<User> date = userMapper.selectPage(pageNum, pageSize);
        res.put("date",date);
        res.put("total",count);
        return res;
    }


    //削除
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }
}
