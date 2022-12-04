package com.hzh;

/**
 * @NAME: NewPar
 * @USER: DaHuangGO
 * @DATE: 2022/12/5
 * @TIME: 0:22
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 05
 */
public class NewPar2 {
    public static void main(String[] args) {
        byte[] b=null;
        //每次分配1mb
        for (int i = 0; i < 10; i++) {
            b=new byte[1*1024*1024];
        }
    }
}
