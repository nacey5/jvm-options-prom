package com.hzh;

import jdk.dynalink.linker.support.Lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * @NAME: SimpleMethodHandler
 * @USER: DaHuangGO
 * @DATE: 2022/12/11
 * @TIME: 14:19
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 11
 * invokeMethod 的调用
 */
public class SimpleMethodHandler {
    static class MyPrintln{
        protected void println(String s){
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws Throwable {
        Object obj=(System.currentTimeMillis()&1L)==0L?System.out:new MyPrintln();
        System.out.println(obj.getClass().toString());
        getPrintlnMethodHandler(obj).invokeExact("geym");
    }

    private static MethodHandle getPrintlnMethodHandler(Object receiver) {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(receiver.getClass(),"println",methodType).bindTo(receiver);
    }

    private static Lookup lookup() {
        return null;
    }

}
