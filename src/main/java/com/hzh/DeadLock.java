package com.hzh;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @NAME: DeadLock
 * @USER: DaHuangGO
 * @DATE: 2022/12/8
 * @TIME: 14:27
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 08
 * 死锁测试
 */
public class DeadLock extends Thread{
    protected Object myDirect;
    static ReentrantLock south=new ReentrantLock();
    static ReentrantLock north=new ReentrantLock();

    public DeadLock(Object object){
        this.myDirect=object;
        if (myDirect==south){
            this.setName("south");
        }
        if (myDirect==north){
            this.setName("north");
        }
    }

    @Override
    public void run() {
        if (myDirect==south){
            try {
                north.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (Exception e){e.printStackTrace();}
                south.lockInterruptibly();
                System.out.println("cat to south has passed");
            }catch (Exception e){
                System.out.println(" cat to is killed");
            }finally {
                if (north.isHeldByCurrentThread()){
                    north.unlock();
                }
                if (south.isHeldByCurrentThread()){
                    south.unlock();
                }
            }
        }

        if (myDirect==north){
            try {
                south.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                north.lockInterruptibly();
                System.out.println("car to north has passed");
            }catch (Exception e){
                System.out.println("car to north is killed");
            }finally {
                if (north.isHeldByCurrentThread()){
                    north.unlock();
                }
                if (south.isHeldByCurrentThread()){
                    south.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock car2south=new DeadLock(south);
        DeadLock car2north=new DeadLock(north);
        car2south.start();
        car2north.start();
        Thread.sleep(1000);
    }
}
