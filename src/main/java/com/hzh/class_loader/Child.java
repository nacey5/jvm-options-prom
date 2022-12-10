package com.hzh.class_loader;

/**
 * @NAME: Child
 * @USER: DaHuangGO
 * @DATE: 2022/12/10
 * @TIME: 15:37
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 10
 */
public class Child extends Parent{
    static {
        System.out.println("Child init");
    }
}
