package com.hzh;

/**
 * @NAME: AllocEden
 * @USER: DaHuangGO
 * @DATE: 2022/12/7
 * @TIME: 16:50
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 07
 */
public class AllocEden {
    public static final int _1K=1024;

    public static void main(String[] args) {
        for (int i = 0; i < 5 * _1K; i++) {
            byte[] b=new byte[_1K];
        }
    }
}
