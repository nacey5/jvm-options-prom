package com.hzh;

/**
 * @NAME: VolatileTest
 * @USER: DaHuangGO
 * @DATE: 2022/12/9
 * @TIME: 16:17
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 09
 * volatile 参数有跨线程可见性，如果去除，stop参数状态的改变对于其他线程来讲是不可见的
 */
public class VolatileTest {
    public static class MyThread extends Thread{

        private volatile boolean stop=false;

        public void stopMe(){
            stop=true;
        }
        @Override
        public void run() {
            int i=0;
            while (!stop){
                i++;
            }
            System.out.println("Stop Thread");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t=new MyThread();
        t.start();
        Thread.sleep(1000);
        t.stopMe();
        Thread.sleep(1000);
    }
}
