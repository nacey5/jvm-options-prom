package com.hzh;

/**
 * @NAME: LockEliminate
 * @USER: DaHuangGO
 * @DATE: 2022/12/9
 * @TIME: 14:55
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 09
 * 锁消除--在没有同步场景中使用锁基于逃逸分析jit会自动进行锁消除
 * -XX:+DoEscapeAnalysis
 * -XX:+EliminateLocks
 */
public class LockEliminate {
    private static final int CIRCLE=200_000_0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            createStringBuffer("JVM","Diagnosis");
        }
        long end = System.currentTimeMillis();
        System.out.println("createStringBuffer: "+(end-start)+"ms");
    }

    private static String createStringBuffer(String jvm, String diagnosis) {
        StringBuffer sb=new StringBuffer();
        sb.append(jvm);
        sb.append(diagnosis);
        return sb.toString();
    }
}
