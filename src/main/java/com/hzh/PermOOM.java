package com.hzh;

import java.lang.reflect.Proxy;

/**
 * @NAME: PermOOM
 * @USER: DaHuangGO
 * @DATE: 2022/12/8
 * @TIME: 20:04
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 08
 */
public class PermOOM {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 100_000; i++) {
               //创建代理对象过多可能导致元空间溢出
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
