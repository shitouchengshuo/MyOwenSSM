package com.qiqi.testRedis.controller;

import com.google.common.collect.Lists;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;

/**
 *后台管理redis集群简单接口
 *
 */
@Controller
public class RedisMangerController {

    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(RedisMangerController.class);

    private JedisCluster jedisCluster;

    @Autowired
    public RedisMangerController(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
        Assert.notNull(this.jedisCluster);
    }

    /**
     * 查看所有的key值
     */
    @RequestMapping(value = "cache/redis/keys", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<String> queryKeys() {
        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
        List<String> keys = Lists.newArrayList();
        for(String k : clusterNodes.keySet()){
            JedisPool jp = clusterNodes.get(k);
            try (Jedis connection = jp.getResource()) {
                keys.addAll(connection.keys("*"));
            } catch (Exception e) {
                //logger.info(ExceptionUtil.getErrorMessage(e));
            }
        }
        return keys;
    }

    /**
     * 查看redisInfo
     */
    @RequestMapping(value = "cache/redis/info", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<String> queryRedisInfo() {
        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
        List<String> redisInfo = Lists.newArrayList();
        for(String k : clusterNodes.keySet()){
            JedisPool jp = clusterNodes.get(k);
            try (Jedis connection = jp.getResource()) {
                redisInfo.add(connection.info());
            } catch (Exception e) {
                //logger.info(ExceptionUtil.getErrorMessage(e));
            }
        }
        return redisInfo;
    }

    /**
     * 清除所有的key值
     */
//    @RequestMapping(value = "cache/redis/clean", method = RequestMethod.POST,
//            consumes = "application/json", produces = "application/json")
//    @ResponseBody
//    public CommonResponse clean() {
//        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
//        for(String k : clusterNodes.keySet()){
//            JedisPool jp = clusterNodes.get(k);
//            try (Jedis connection = jp.getResource()) {
//                connection.flushAll();
//            } catch (Exception e) {
//                logger.info(ExceptionUtil.getErrorMessage(e));
//            }
//        }
//        return CommonResponse.ok();
//    }

}
