package com.hzh;

/**
 * @NAME: LongFinalize
 * @USER: DaHuangGO
 * @DATE: 2022/12/7
 * @TIME: 19:43
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 07
 */
public class LongFinalize {
    public static class LF{
        private byte[] content=new byte[512];

        @Override
        protected void finalize() throws Throwable {
            try {
                System.out.println(Thread.currentThread().getId());
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50_000; i++) {
            LF lf=new LF();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
