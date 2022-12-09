package com.hzh;

import java.util.ArrayList;
import java.util.List;

/**
 * @NAME: ThreadUnSafe
 * @USER: DaHuangGO
 * @DATE: 2022/12/9
 * @TIME: 13:55
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 09
 */
public class ThreadUnSafe {
    public static List<Integer> numberList=new ArrayList<>();

    public static class AddToList implements Runnable{
        int startNum=0;
        public  AddToList(int startNum){
            this.startNum=startNum;
        }
        @Override
        public void run() {
            int count=0;
            while (count<100_000_0){
                numberList.add(startNum);
                startNum+=2;
                count++;
            }
        }
    }


    public static void main(String[] args) {
        Thread t1=new Thread(new AddToList(0));
        Thread t2=new Thread(new AddToList(1));
        t1.start();
        t2.start();
    }
}
