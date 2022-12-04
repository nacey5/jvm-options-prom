package com.hzh;

/**
 * @NAME: SimpleArgs
 * @USER: DaHuangGO
 * @DATE: 2022/12/3
 * @TIME: 16:44
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 03
 */
public class SimpleArgs {
    /**
     * -Xmx32m 堆的最大大小
     * args是附带main的参数
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args"+(i+1)+":"+args[i]);
        }
        System.out.println("-Xmx"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
    }
}
