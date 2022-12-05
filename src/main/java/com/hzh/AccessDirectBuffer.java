package com.hzh;

import java.nio.ByteBuffer;

/**
 * @NAME: AccessDirectBuffer
 * @USER: DaHuangGO
 * @DATE: 2022/12/5
 * @TIME: 12:09
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 05
 */
public class AccessDirectBuffer {
    public void directAccess(){
        long startTime = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocateDirect(500);
        for (int i = 0; i < 1_000_000; i++) {
            for (int j = 0; j < 99; j++) {
                b.putInt(j);
            }
            b.flip();
            for (int j = 0; j < 99; j++) {
                b.getInt();
            }
            b.clear();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testDirectWrite:"+(endTime-startTime));
    }

    public void bufferAccess(){
        long startTime = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocate(500);
        for (int i = 0; i < 1_000_000; i++) {
            for (int j = 0; j < 99; j++) {
                b.putInt(j);
            }
            b.flip();
            for (int j = 0; j < 99; j++) {
                b.getInt();
            }
            b.clear();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testBufferWrite:"+(endTime-startTime));
    }

    public static void main(String[] args) {
        AccessDirectBuffer accessDirectBuffer=new AccessDirectBuffer();
        accessDirectBuffer.bufferAccess();
        accessDirectBuffer.directAccess();

        accessDirectBuffer.bufferAccess();
        accessDirectBuffer.directAccess();
    }
}
