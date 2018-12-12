package com.qiqi.juint.service;

import com.qiqi.juint.model.User;
import com.qiqi.juint.model.vo.UserVO;

import java.util.List;

/**
 * Created by ZhaoQiqi on 2018/11/8.
 */
public interface UserService {

    List<UserVO> getUserInfo(Integer age);

    void insertUser(User user);
}
