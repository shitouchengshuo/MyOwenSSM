package com.qiqi.juint.test.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

/**
 * Created by ZhaoQiqi on 2018/11/7.
 */
@Data
public class User {

    private Integer age;
    private String name;

    public User() {
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "++++++++++"+"age"+age+":"+name+"++++++++++";
    }
}
