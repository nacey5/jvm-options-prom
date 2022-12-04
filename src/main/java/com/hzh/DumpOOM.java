package com.hzh;

import java.util.Vector;

/**
 * @NAME: DumpOOM
 * @USER: DaHuangGO
 * @DATE: 2022/12/5
 * @TIME: 0:49
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 05
 */
public class DumpOOM {
    public static void main(String[] args) {
        Vector vector=new Vector();
        for (int i = 0; i < 25; i++) {
            vector.add(new byte[1*1024*1024]);
        }
    }
}
