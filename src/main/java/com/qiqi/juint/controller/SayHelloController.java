package com.qiqi.juint.controller;

import com.qiqi.juint.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ( "/myTest" )
public class SayHelloController {

    @RequestMapping("sayHello1")
    public void sayHello1(){
        System.out.println("-------sayHello1------");
    }

    @RequestMapping("sayHello2")
    public ModelAndView sayHello2( ){
        User user = new User(11,"qiqi");

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user/view");
        return mv;
    }

    @RequestMapping("sayHello3")
    public ModelAndView sayHello3( ){
        User user = new User(11,"qiqi");

        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user/view");
        return mv;
    }

}