package com.hzh;

import java.util.HashMap;
import java.util.Map;

/**
 * @NAME: PretenureSizeThreshold
 * @USER: DaHuangGO
 * @DATE: 2022/12/7
 * @TIME: 17:47
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 07
 */
public class PretenureSizeThreshold {
    public static final int _1K=1024;

    public static void main(String[] args) {
        Map<Integer,byte[]> map=new HashMap<>();
        for (int i = 0; i < 5 * _1K; i++) {
            byte[] b=new byte[_1K];
            map.put(i,b);
        }
    }
}
