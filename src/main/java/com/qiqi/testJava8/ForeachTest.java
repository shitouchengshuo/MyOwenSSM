package com.qiqi.testJava8;

import com.qiqi.testJava8.model.User;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ForeachTest {

    public static void main(String[] args) {
        // int n = 1;
        // switch (n) {
        //     case 1:
        //         System.out.println("this is one.");
        //         //break;
        //     case 2:
        //         System.out.println("this is two.");
        //         break;
        //     default:
        //         System.out.println("Others.");
        // }

        Map<String,User> map =new HashMap<>();
        map.put("1",new User("aa",10));
        map.put("2",new User("bb",11));
        map.put("3",new User("cc",12));

        //匹配输出，匹配项可以为list集合元素的属性（成员变量）
        map.forEach((t,v)->System.out.println("id : " + t + " User : " + v));
    }

}
