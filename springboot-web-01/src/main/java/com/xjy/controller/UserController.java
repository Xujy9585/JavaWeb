package com.xjy.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.xjy.pojo.User;
import com.xjy.service.UserService;
import com.xjy.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    public UserService userService = new UserServiceImpl();

    @RequestMapping("/list")
    public List<User> list(){
        // 1.调用service,获取数据
        List<User> userList = userService.findAll();

        // 2. 返回数据（json）
        return userList;
    }


//    @RequestMapping("/list")
//    public String list() throws Exception {
//        //1.加载并读取文件
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//
//        //2.解析数据，封装成对象 --> 集合
//        List<User> userList = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//            return new User(id, username, password, name, age, updateTime);
//        }).collect(Collectors.toList());
//
//        //3.响应数据
//        //return JSONUtil.toJsonStr(userList, JSONConfig.create().setDateFormat("yyyy-MM-dd HH:mm:ss"));
//        return userList.toString();
//    }
}
