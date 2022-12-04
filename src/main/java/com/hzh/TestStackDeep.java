package com.hzh;

/**
 * @NAME: TestStackDeep
 * @USER: DaHuangGO
 * @DATE: 2022/12/4
 * @TIME: 13:50
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 04
 * -Xss128k 表示了方法栈的深度
 * 局部变量过多导致栈溢出会抛出java.lang.StackOverflowError
 */
public class TestStackDeep {
    private static int count=0;
    public static void recursion(){
        count++;
        recursion();
    }

    public static void recursion(long a,long b,long c){
        long e=1,f=2,g=3,h=4,i=5,j=6,k=7,l=8,m=9,z=10;
        count++;
        recursion(a, b, c);
    }

    public static void main(String[] args) {
        //t1
//        try {
//            recursion(0l,0l,0l);
//        }catch (Throwable e){
//            System.out.println("deep of calling="+count);
//            e.printStackTrace();
//        }
        //t2
//        TestStackDeep t=new TestStackDeep();
//        t.localVar1();
//        t.localVar2();
        //t3
        TestStackDeep t=new TestStackDeep();
        t.localVarGC4();

    }

    public void localVar1(){
        int a=0;
        System.out.println(a);
        int b=0;
    }

    public void localVar2(){
        {
            int a=0;
            System.out.println(a);
        }
        int b=0;
    }

    //测试局部变量对GC的影响
    public void localVarGC1(){
        byte[] a=new byte[6*1024*1024];
        System.gc();
    }
    public void localVarGC2(){
        byte[] a=new byte[6*1024*1024];
        a=null;
        System.gc();
    }
    public void localVarGC3(){
        {
            byte[] a=new byte[6*1024*1024];
        }
        System.gc();
    }
    public void localVarGC4(){
        {
            byte[] a=new byte[6*1024*1024];
        }
        int c=10;
        System.gc();
    }
    public void localVarGC5(){
        localVarGC1();
        System.gc();
    }
}
