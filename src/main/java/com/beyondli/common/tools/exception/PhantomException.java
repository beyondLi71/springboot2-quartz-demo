package com.beyondli.common.tools.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author beyondLi
 * @desc 自定义异常.
 */
@Data
@NoArgsConstructor
public class PhantomException extends RuntimeException {


    public PhantomException(String id, String appName, String ip, String code, String msg) {
        this.id = id;
        this.appName = appName;
        this.ip = ip;
        this.code = code;
        this.msg = msg;
    }

    //异常id
    private String id;

    private String appName;

    private String ip;

    //错误码
    private String code;

    //错误提示信息
    private String msg;

    @Override
    public String toString() {
        return String.format("{\"appName\":\"%s\",\"code\":\"%s\",\"id\":\"%s\",\"ip\":\"%s\",\"msg\":\"%s\"}",
                this.appName, this.code, this.id, this.ip, this.msg);

    }
}
