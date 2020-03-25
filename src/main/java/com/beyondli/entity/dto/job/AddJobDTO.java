package com.beyondli.entity.dto.job;

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
public class AddJobDTO {
    //组
    private String jobGroup;
    //名称
    private String jobName;
    //类名称
    private String beanClass;
    //cron表达式
    String cronExpression;

}
