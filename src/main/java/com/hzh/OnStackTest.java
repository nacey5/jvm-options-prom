package com.hzh;

/**
 * @NAME: OnStackTest
 * @USER: DaHuangGO
 * @DATE: 2022/12/4
 * @TIME: 15:52
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 04
 */
public class OnStackTest {
    public static class User{
        public int id=0;
        public String name="";
    }

    public static void alloc(){
        User user=new User();
        user.id=5;
        user.name="daHuang";
    }
    //观察gc信息 jdk9以后-Xlog:gc* or -Xlog:gc
    //jdk8 及以前 -XX:+PrintGC or -XX:+PrintGCDetails
    //-XX:+PrintVMOptions 输出虚拟机参数
    //-XX:+PrintCommandLineFlags 输出虚拟机启用标记
    //-Xlog:class+load=info 类下载信息
    //-Xlog:class+unload=info 类卸载信息
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_000_00; i++) {
                alloc();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
