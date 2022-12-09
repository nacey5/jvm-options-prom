package com.hzh;

/**
 * @NAME: MultiThreadVolatileLong
 * @USER: DaHuangGO
 * @DATE: 2022/12/9
 * @TIME: 16:04
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 09
 * 32位虚拟机对long和double等占用64字节的的进行指令重排可能导致数据读取顺序发生错误
 */
public class MultiThreadVolatileLong {
    public static long t=0;
    public static class ChangeT implements Runnable{

        private long to;

        public ChangeT(long to) {
            this.to=to;
        }

        @Override
        public void run() {
            while (true){
                MultiThreadVolatileLong.t=to;
                Thread.yield();
            }
        }
    }

    public static class ReadT implements Runnable{

        @Override
        public void run() {
            while (true){
                long tmp=MultiThreadVolatileLong.t;
                if (tmp!=111L&&tmp!=-999L&&tmp!=333L&&tmp!=-444L){
                    System.out.println(tmp);
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ChangeT(111L)).start();
        new Thread(new ChangeT(-999L)).start();
        new Thread(new ChangeT(333L)).start();
        new Thread(new ChangeT(-444L)).start();
        new Thread(new ReadT()).start();
    }
}
