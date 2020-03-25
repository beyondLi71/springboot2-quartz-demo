package com.beyondli.common.utils.apiresult;

import lombok.Data;

/**
 * @author    beyondLi
 * @desc    正确返回体
 */
@Data
public class SuccessApiResult extends AbstractApiResult {

    private Object data;

    SuccessApiResult(Object data) {
        this.code = "0";
        this.data = data;
    }

}
