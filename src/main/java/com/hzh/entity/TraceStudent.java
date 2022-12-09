package com.hzh.entity;

import java.util.List;
import java.util.Vector;

/**
 * @NAME: TraceStudent
 * @USER: DaHuangGO
 * @DATE: 2022/12/8
 * @TIME: 22:00
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 08
 */
public class TraceStudent {
    static List<WebPage> webPages=new Vector<>();

    public static void createWebPages(){
        for (int i = 0; i < 100; i++) {
            WebPage wp=new WebPage();
            wp.setUrl("http://www."+Integer.toString(i)+".com.cn");
            wp.setContent(Integer.toString(i));
            webPages.add(wp);
        }
    }

    public static void main(String[] args) {
        createWebPages();
        Student st3=new Student(3,"h1");
        Student st5=new Student(5,"h2");
        Student st7=new Student(7,"h3");
        for (int i = 0; i < webPages.size(); i++) {
            if (i%st3.getId()==0){
                st3.visit(webPages.get(i));
            }
            if (i%st5.getId()==0){
                st5.visit(webPages.get(i));
            }
            if (i%st7.getId()==0){
                st7.visit(webPages.get(i));
            }
        }
        webPages.clear();
        System.gc();
    }
}
