package com.qiqi.juint.test.service.impl;

import com.google.common.collect.Maps;
import com.qiqi.juint.test.model.User;
import com.qiqi.juint.test.service.RedisService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.JedisCluster;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhaoQiqi on 2018/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //声明一个ApplicationContext集成测试加载WebApplicationContext，作用是模拟ServletContext
@ContextConfiguration(locations={"classpath:spring/spring-application.xml"})
@Service
public class RedisServiceImpl implements RedisService {

    //private static final Logger logger = Logger.getLogger(RedisServiceImpl.class);

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void testRedis( ) {
        jedisCluster.set("1","哈哈");
        System.out.println(jedisCluster.get("1"));
        Map map = Maps.newHashMap();
        map.put(1,new User(1,""));
        jedisCluster.hmset("1",map);
    }
}
