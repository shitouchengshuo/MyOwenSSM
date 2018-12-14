package com.qiqi.juint.service.impl;

import com.qiqi.juint.dao.UserMapper;
import com.qiqi.juint.model.User;
import com.qiqi.juint.model.vo.UserVO;
import com.qiqi.juint.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-application.xml"})
@Transactional()
//@Rollback(false)//用于单元测试时关闭回滚
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserServiceTestTransactionImpl userServiceTestTransaction;
    @Autowired
    private UserMapper userMapper;

    public List<UserVO> getUserInfo(Integer age) {
        logger.info("调用方法getUserInfo(Integer age)");
        return userMapper.getUserInfo(age);
    }


    public void insertUser(User user)  {
        try {

            userMapper.inserUser(new User(11,"格格A"));
            userServiceTestTransaction.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException();
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        //userMapper.inserUser(user);
        //throw new RuntimeException();
        //throw new IOException();

    }

    @Test
    public void test() throws Exception {
        logger.info("调用insert(User user)方法");
        insertUser(new User(11, "格格B"));

       // boolean exist = userMapper.exist(11);
        System.out.println("exist:  =====================" );
    }
}
