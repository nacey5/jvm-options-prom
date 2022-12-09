package com.hzh.entity;

import lombok.Data;

import java.util.List;
import java.util.Vector;

/**
 * @NAME: Student
 * @USER: DaHuangGO
 * @DATE: 2022/12/8
 * @TIME: 21:58
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 08
 */

@Data
public class Student {
    private int id;
    private String name;
    private List<WebPage> history=new Vector<>();

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public void visit(WebPage webPage) {
        System.out.println(webPage.getContent());
    }
}
