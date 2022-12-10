package com.hzh;

/**
 * @NAME: printClassLoaderTree
 * @USER: DaHuangGO
 * @DATE: 2022/12/10
 * @TIME: 16:11
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 10
 */
public class PrintClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader classLoader = PrintClassLoaderTree.class.getClassLoader();
        while (classLoader!=null){
            System.out.println(classLoader);
            classLoader=classLoader.getParent();
        }
    }
}
