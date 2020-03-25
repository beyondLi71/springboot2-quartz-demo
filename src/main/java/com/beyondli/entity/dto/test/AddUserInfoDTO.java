package com.beyondli.entity.dto.test;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:24
 * Desc .
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserInfoDTO {
    //姓名
    @ApiModelProperty(value="用户名",name="name",example="beyondLi")
    @NotBlank(message = "USER_0001")
    private String name;
    //年龄
    @ApiModelProperty(value="年龄",name="age",example="18")
    @NotNull(message = "USER_0002")
    private Integer age;
}
