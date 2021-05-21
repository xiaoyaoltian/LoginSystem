package com.hm.config;

import lombok.Data;

/**
 * @author : HM
 * @date : 2021-05-20 15:25
 * @description
 **/
@Data
public class Result {
    private int code;
    public Result(int code) {
        this.code = code;
    }
}
