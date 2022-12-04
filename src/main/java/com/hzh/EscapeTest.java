package com.hzh;

import com.hzh.entity.User;

/**
 * @NAME: EscapeTest
 * @USER: DaHuangGO
 * @DATE: 2022/12/4
 * @TIME: 15:48
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 04
 */
public class EscapeTest {

    //逃逸对象
    private static User user;
    public static void alloc(){
        //User可能被其他对象访问到，所以属于逃逸对象
        user=new User();
        user.getAge();
        user.getId();
    }

    //不属于逃逸对象
    public static void alloc2(){
        User user2=new User();
        user.getId();
        user.getAge();
    }
}
