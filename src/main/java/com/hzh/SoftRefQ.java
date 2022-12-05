package com.hzh;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @NAME: SoftRefQ
 * @USER: DaHuangGO
 * @DATE: 2022/12/5
 * @TIME: 17:00
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 05
 * 软引用队列测试
 */
public class SoftRefQ {
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

    static ReferenceQueue<User> softQueue=null;

    public static class CheckRefQueue extends Thread{
        @Override
        public void run() {
            while (true){
                if (softQueue!=null){
                    UserSoftReference obj=null;
                    try{
                        obj= (UserSoftReference) softQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (obj!=null){
                        System.out.println("user id "+obj.uid+"is delete");
                    }
                }
            }
        }
    }

    public static class UserSoftReference extends SoftReference<User>{
        int uid;
        public UserSoftReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            uid=referent.id;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t=new CheckRefQueue();
        t.setDaemon(true);
        t.start();
        User r=new User(1,"daHuangGo");
        softQueue=new ReferenceQueue<>();
        UserSoftReference userSoftReference=new UserSoftReference(r,softQueue);
        r=null;
        System.out.println(userSoftReference.get());
        System.gc();
        //内存足够，不会被回收
        System.out.println("After Gc:");
        System.out.println(userSoftReference.get());

        System.out.println("try to create byte array and GC");
        byte[] b=new byte[1024*925*7];
        System.gc();
        System.out.println(userSoftReference.get());

        Thread.sleep(1000);
    }
}
