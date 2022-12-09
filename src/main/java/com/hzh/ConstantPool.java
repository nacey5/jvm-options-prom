package com.hzh;

/**
 * @NAME: ConstantPool
 * @USER: DaHuangGO
 * @DATE: 2022/12/8
 * @TIME: 20:50
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 08
 * 3次Hash值都是不同的。但是如果不进行程序中的显式
 * GC操作，那么后两次Hash值理应是相同的
 */
public class ConstantPool {
    public static void main(String[] args) {
        if (args.length==0){
            return;
        }
        System.out.println(System.identityHashCode((args[0]+Integer.toString(0))));
        System.out.println(System.identityHashCode((args[0]+Integer.toString(0)).intern()));
        System.gc();
        System.out.println(System.identityHashCode((args[0]+Integer.toString(0)).intern()));
    }
}
