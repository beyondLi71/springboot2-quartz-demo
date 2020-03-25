package com.beyondli.entity.dto.job;

import io.swagger.annotations.ApiModelProperty;
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
public class ManagerJobDTO {
    //组
    private String jobGroup;
    //名称
    private String jobName;

}
