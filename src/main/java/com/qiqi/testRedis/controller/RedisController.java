package com.qiqi.testRedis.controller;

import com.qiqi.testRedis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZhaoQiqi on 2018/11/15.
 */
@Controller
@RequestMapping( "/myRedis" )
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "tset",method = RequestMethod.GET)
    public String test( ){
        redisService.testRedis();
        return "test";
    }
}
