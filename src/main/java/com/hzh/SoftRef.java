package com.hzh;

import java.lang.ref.SoftReference;

/**
 * @NAME: SoftRef
 * @USER: DaHuangGO
 * @DATE: 2022/12/5
 * @TIME: 16:50
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 05
 *
 * 软引用测试
 */
public class SoftRef {
    public static class User{

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int id;
        public String name;

        @Override
        public String toString() {
            return "[id="+String.valueOf(id)+",name="+name+"]";
        }
    }

    public static   void main(String[] args) {
        User user=new User(1,"daHuangGo");
        SoftReference<User> userSoftReference=new SoftReference<>(user);

        user=null;

        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After Gc:");
        System.out.println(userSoftReference.get());

        byte[] b=new byte[1024*925*7];
        System.gc();
        System.out.println(userSoftReference.get());
    }

}
