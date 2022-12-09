package com.hzh;

import java.util.List;
import java.util.Vector;

/**
 * @NAME: Biased
 * @USER: DaHuangGO
 * @DATE: 2022/12/9
 * @TIME: 14:19
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 09
 * 偏向锁性能测试
 * -XX:+UseBiasedLocking可以设置启用偏向锁
 */
public class Biased {
    public static List<Integer> numberList=new Vector<>();

    public static void main(String[] args) {
        long begin=System.currentTimeMillis();
        int count=0;
        int startNum=0;
        while (count<100_000_00){
            numberList.add(startNum);
            startNum+=2;
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }
}
