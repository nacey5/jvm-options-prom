package com.hzh;

import java.nio.ByteBuffer;

/**
 * @NAME: AllocDirectBuffer
 * @USER: DaHuangGO
 * @DATE: 2022/12/5
 * @TIME: 12:28
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 05
 */
public class AllocDirectBuffer {
    public void directAllocate(){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200_000; i++) {
            ByteBuffer b = ByteBuffer.allocateDirect(1_000);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testDirectAllocate:"+(endTime-startTime));
    }

    public void bufferAllocate(){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200_000; i++) {
            ByteBuffer b = ByteBuffer.allocate(1_000);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testBufferAllocate:"+(endTime-startTime));
    }

    public static void main(String[] args) {
        AllocDirectBuffer accessDirectBuffer=new AllocDirectBuffer();
        accessDirectBuffer.bufferAllocate();
        accessDirectBuffer.directAllocate();

        accessDirectBuffer.bufferAllocate();
        accessDirectBuffer.directAllocate();
    }
}
