package com.hzh;

import java.util.Random;

/**
 * @NAME: HoldLockMain
 * @USER: DaHuangGO
 * @DATE: 2022/12/8
 * @TIME: 12:38
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 08
 * IO资源/CPU资源占用--->大量触发
 */
public class HoldLockMain {
    public static Object[] lock=new Object[10];
    public static Random r=new Random();
    static {
        for (int i = 0; i < lock.length; i++) {
            lock[i]=new Object();
        }
    }
    public static class HoldLockTask implements Runnable{
        private int i;
        public HoldLockTask(int i){
            this.i=i;
        }
        @Override
        public void run() {
            try {
                while (true){
                    synchronized (lock[i]){
                        if (i%2==0){
                            lock[i].wait(r.nextInt());
                        }else {
                            lock[i].notifyAll();
                        }
                    }
                }
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < lock.length * 2; i++) {
            new Thread(new HoldLockTask(i/2)).start();
        }
    }
}
