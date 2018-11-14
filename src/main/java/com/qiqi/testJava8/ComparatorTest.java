package com.qiqi.testJava8;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    @Test
    public void test1(){
        /**
         * Collections.sort()使用
         */
        //被排序的集合
        List<User> userList = Lists.newArrayList(new User("Jack",11),new User("Jack",10));

        //1. Java8之前，使用匿名内部类的基本排序
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getAge().compareTo(user2.getAge());
            }
        });

        //2. Java8,使用Lambda表达式的基本排序
        Collections.sort(userList,(User user1, User user2) -> user1.getAge().compareTo(user2.getAge()));

        //3. Java8,Lambda表达式可以简化，省略定义类型User
        userList.sort((user1, user2) -> user1.getAge().compareTo(user2.getAge()));

        //4. Java8,Lambda表达式，多条件排序
        userList.sort((user1, user2) -> {
            if (user1.getName().equals(user2.getName())) {
            return user1.getAge() - user2.getAge();
            } else {
            return user1.getName().compareTo(user2.getName());
            }
        });

        //5. Java8,多条件组合排序
        userList.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));

        //6. Java8,提取Comparator进行排序
        Collections.sort(userList, Comparator.comparing(User::getName));

        //7. Java8,自定义静态的比较方法来排序(静态方法必须写在被比较的类(这里是User类)中)
        userList.sort(User::compareByAgeThenName);

        //8. Java8,反转排序
        Comparator<User> comparator = (user1, user2) -> user1.getName().compareTo(user2.getName());
        userList.sort(comparator);//先按name排序
        userList.sort(comparator.reversed());//反转排序
        Assert.assertEquals(userList.get(0),new User("Jack",10));

        /**
         * Arrays.sort()使用
         */
        //被排序的字符串数组
        String[] months = {"January","February","March","April","May","June","July","August","September","October","December"};
        //按字符串长度排序
        //1.
        Arrays.sort(months, (a, b) -> Integer.signum(a.length() - b.length()));
        //2.
        Arrays.sort(months, Comparator.comparingInt(String::length));
        //3.
        Arrays.sort(months, (a, b) -> a.length() - b.length());
        //4.
        Arrays.sort(months,
                (String a, String b) -> { return Integer.signum(a.length() - b.length()); }
        );

        System.out.println(Arrays.toString(months));
    }
}
