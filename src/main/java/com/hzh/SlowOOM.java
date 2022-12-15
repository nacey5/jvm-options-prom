package com.hzh;

import java.util.LinkedList;

/**
 * @NAME: SlowOOM
 * @USER: DaHuangGO
 * @DATE: 2022/12/16
 * @TIME: 0:41
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 16
 * java -XX:+UnlockExperimentalVMOptions -XX:+UseZGC
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+ZStatisticsForceTrace -Xms512m -Xmx2g
 * -Xlog:gc*=trace:file=detail_slowoom.log:time,tid,tags:filecount=3,
 * filesize=200m -classpath.SlowOOM
 */
public class SlowOOM {

    private static final LinkedList<String> strings = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        int iteration = 0;
        while (true) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 10; j++) {
                    strings.add(new String("String " + j));
                }
            }
            Thread.sleep(100);
        }
    }
}
