package com.qiqi.juint.service.impl;

import com.qiqi.juint.dao.UserMapper;
import com.qiqi.juint.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
@Transactional//(rollbackFor = IOException.class ,propagation = Propagation.SUPPORTS)
@Service
public class UserServiceTestTransactionImpl {

    @Autowired
    private UserMapper userMapper;

    public void insertUser(User user)throws Exception{
        userMapper.inserUser(user);
        System.out.println("UserServiceTestTransactionImpl的insertUser------------------------");
        throw new IOException();
        //throw new RuntimeException();
        //throw new Error();
    }

}
