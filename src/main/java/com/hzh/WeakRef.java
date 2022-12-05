package com.hzh;

import java.lang.ref.WeakReference;

/**
 * @NAME: WeakRef
 * @USER: DaHuangGO
 * @DATE: 2022/12/5
 * @TIME: 17:22
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 05
 */
public class WeakRef {
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

    public static void main(String[] args) {
        User user=new User(1,"daHuangGo");
        WeakReference<User> weakReference=new WeakReference<>(user);
        user=null;
        System.out.println(weakReference.get());
        System.gc();
        //不管当前空间是否足够，都会回收弱引用
        System.out.println("After GC");
        System.out.println(weakReference.get());
    }
}
