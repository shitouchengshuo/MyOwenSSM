package com.qiqi.juint.controller;

import com.qiqi.juint.model.User;
import com.qiqi.juint.model.vo.UserVO;
import com.qiqi.juint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ZhaoQiqi on 2018/11/8.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "jsp1",method = RequestMethod.GET)
    public String getJsp( ){
        return "test";
    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @ResponseBody
    public List<UserVO> getUserInfo(@RequestParam Integer age){
        return userService.getUserInfo(age);
    }

    @RequestMapping(value = "insertUser", method = RequestMethod.POST)
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }
}
