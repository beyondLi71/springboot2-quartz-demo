package com.beyondli.repository.job;

import com.beyondli.entity.po.job.JobInfoPO;
import com.beyondli.entity.po.test.UserInfoPO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:19
 * Desc .
 */
public interface JobQueryMapper {

    /**
     * 查询开启中的任务
     * @return
     */
    @Select("SELECT id, job_name AS jobName, description, cron_expression AS cronExpression, bean_class AS beanClass, job_status AS jobStatus, job_group AS jobGroup, create_user AS createUser, create_time AS createTime, update_user AS updateUser, update_time AS updateTime FROM sys_task WHERE job_status = 'START'")
    List<JobInfoPO> getStratJobList();
}
