package com.hzh;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @NAME: SimpleStaticMethodHandler
 * @USER: DaHuangGO
 * @DATE: 2022/12/11
 * @TIME: 14:29
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 11
 */
public class SimpleStaticMethodHandler {
    public static void main(String[] args) throws Throwable {
        SimpleStaticMethodHandler obj=new SimpleStaticMethodHandler();
        System.out.println(obj.callsin());
    }

    private double callsin() throws Throwable {
        MethodHandle mh= MethodHandles.lookup().findStatic(Math.class,"sin", MethodType.methodType(double.class,double.class));
        return (double) mh.invokeExact(Math.PI/2);
    }
}
