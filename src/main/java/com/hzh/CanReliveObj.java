package com.hzh;

import java.lang.ref.Cleaner;

/**
 * @NAME: CanReliveObj
 * @USER: DaHuangGO
 * @DATE: 2022/12/5
 * @TIME: 15:37
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 05
 */
public class CanReliveObj {
    public static CanReliveObj obj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called");
        obj=this;
    }

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }

    public static void main(String[] args) throws InterruptedException {
        obj=new CanReliveObj();
        obj=null;
        System.gc();
        Thread.sleep(1000);
        if (obj==null){
            System.out.println("obj 是 null");
        }else {
            System.out.println("obj 可用");
        }

        System.out.println("第二次gc");
        obj=null;
        System.gc();
        Thread.sleep(1000);
        if (obj==null){
            System.out.println("obj 是 null");
        }else {
            System.out.println("obj 可用");
        }
    }


}
