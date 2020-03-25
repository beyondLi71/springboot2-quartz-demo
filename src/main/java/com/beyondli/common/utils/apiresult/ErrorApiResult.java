package com.beyondli.common.utils.apiresult;

import lombok.Data;

/**
 * @author beyondLi
 * @desc  错误返回.
 */
@Data
public class ErrorApiResult extends AbstractApiResult {

    private String msg;

    ErrorApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
