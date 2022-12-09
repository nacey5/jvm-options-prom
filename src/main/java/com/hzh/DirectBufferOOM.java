package com.hzh;

import java.nio.ByteBuffer;

/**
 * @NAME: DirctBufferOOM
 * @USER: DaHuangGO
 * @DATE: 2022/12/8
 * @TIME: 19:51
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 08
 * 直接内存分配溢出
 */
public class DirectBufferOOM {
    public static void main(String[] args) {
        for (int i = 0; i < 1024; i++) {
            ByteBuffer.allocateDirect(1024*1024);
            System.out.println(i);
            System.gc();
        }
    }
}
