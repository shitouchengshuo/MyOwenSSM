package com.qiqi.juint.service;

import com.qiqi.juint.model.User;
import com.qiqi.juint.model.vo.UserVO;

import java.util.List;

/**
 * 1、用于juint测试web
 * 2、用于进行spring事务回滚的测试
 */
public interface UserService {

   // List<UserVO> getUserInfo(Integer age);

    void insertUser(User user)throws Exception;
}
