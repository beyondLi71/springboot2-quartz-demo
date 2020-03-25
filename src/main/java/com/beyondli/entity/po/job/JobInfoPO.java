package com.beyondli.entity.po.job;

import com.beyondli.entity.enums.job.JobStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:24
 * Desc .
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobInfoPO {
    /*主键ID*/
    private Integer id;
    /*任务名*/
    private String jobName;
    /*任务描述*/
    private String description;
    /*cron表达式*/
    private String cronExpression;
    /*任务执行时调用哪个类的方法 包名+类名*/
    private String beanClass;
    /*任务状态*/
    private JobStatus jobStatus;
    /*任务分组*/
    private String jobGroup;
    /*创建人*/
    private String createUser;
    /*创建时间*/
    private LocalDateTime createTime;
    /*修改人*/
    private String updateUser;
    /*修改时间*/
    private LocalDateTime updateTime;
}
