package com.hzh;

import lombok.Data;

/**
 * @NAME: SimpleUser
 * @USER: DaHuangGO
 * @DATE: 2022/12/10
 * @TIME: 13:59
 * @YEAR: 2022
 * @MONTH: 12
 * @DAY: 10
 */
@Data
public class SimpleUser {
    public static final int Type=1;
    private int id;
    private String name;

    public void setId(int id) {
        try {
            this.id = id;
        } catch (IllegalStateException e) {
            System.out.println(e.toString());
        }
    }
}
