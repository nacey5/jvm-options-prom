package com.hzh;

/**
 * @NAME: SimpleHeap
 * @USER: DaHuangGO
 * @DATE: 2022/12/3
 * @TIME: 17:12
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 03
 */
public class SimpleHeap {
    private int id;

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show() {
        System.out.println("My id is "+id);
    }

    public static void main(String[] args) {
        SimpleHeap s1=new SimpleHeap(1);
        SimpleHeap s2=new SimpleHeap(2);
        s1.show();
        s2.show();
    }
}
