package com.beyondli.entity.po.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:24
 * Desc .
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoPO {
    //id
    private String id;
    //姓名
    private String name;
    //年龄
    private Integer age;
}
