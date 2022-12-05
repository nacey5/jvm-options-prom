package com.hzh;

import java.util.HashMap;
import java.util.Map;

/**
 * @NAME: StopWorldTest
 * @USER: DaHuangGO
 * @DATE: 2022/12/5
 * @TIME: 20:07
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 05
 */
public class StopWorldTest {


        public static class MyThread extends Thread{

            Map map=new HashMap();

            @Override
            public void run() {
                try {
                    while (true){
                        if (map.size()*512/1024/1024>=900){
                            map.clear();
                            System.out.println("clean map");
                        }
                        byte[] b1;
                        for (int i = 0; i < 100; i++) {
                            b1=new byte[512];
                            map.put(System.nanoTime(),b1);
                        }
                        Thread.sleep(1);
                    }
                } catch (InterruptedException e) {

                }
            }
        }

        public static class PrintThread extends Thread{
            public static final long startTime =System.currentTimeMillis();

            @Override
            public void run() {
                try {
                    while (true){
                        long t=System.currentTimeMillis()-startTime;
                        System.out.println(t/1000+"."+t%1000);
                        Thread.sleep(100);
                    }
                }catch (Exception e){

                }
            }
        }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        PrintThread p=new PrintThread();
        myThread.start();;
        p.start();
    }
}
