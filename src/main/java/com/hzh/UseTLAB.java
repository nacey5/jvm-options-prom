package com.hzh;

/**
 * @NAME: UseTLAB
 * @USER: DaHuangGO
 * @DATE: 2022/12/7
 * @TIME: 19:05
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 07
 */
public class UseTLAB {
    public static void alloc(){
        byte[] b=new byte[2];
        b[0]=1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000_00; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
