package com.hzh;

import java.util.ArrayList;
import java.util.List;

/**
 * @NAME: SimpleHeapOOM
 * @USER: DaHuangGO
 * @DATE: 2022/12/8
 * @TIME: 19:48
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 08
 *
 * OOM错误：栈空间溢出：解决方法：扩大栈空间的大小
 */
public class SimpleHeapOOM {
    /**
     * list强引用一直持有byte的引用
     * @param args
     */
    public static void main(String[] args) {
        List<byte[]> list=new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            list.add(new byte[1024*1024]);
        }
    }
}
