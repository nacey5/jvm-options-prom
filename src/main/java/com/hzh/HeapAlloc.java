package com.hzh;

/**
 * @NAME: HeapAlloc
 * @USER: DaHuangGO
 * @DATE: 2022/12/4
 * @TIME: 17:08
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 04
 */
public class HeapAlloc {
    public static void main(String[] args) {
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+" bytes");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()+" bytes");
        byte[] b=new byte[1*1024*1024];
        System.out.println("分配了1MB 空间给数组");
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+" bytes");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()+" bytes");
        b=new byte[4*1024*1024];
        System.out.println("分配了4MB空间给数组");
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+" bytes");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()+" bytes");
    }
}
