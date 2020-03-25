package com.beyondli.common.config.job;

import com.beyondli.entity.po.job.JobInfoPO;
import com.beyondli.repository.job.JobQueryMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
/**
 * 项目启动初始化定时任务
 */
@Component
@Order(value = 1)
public class ScheduleJobInitListener implements ApplicationRunner {

    @Resource
    JobQueryMapper jobQueryMapper;

    @Resource
    JobManager jobManager;


    @Override
    public void run(ApplicationArguments args) {
        List<JobInfoPO> jobInfoPOS = jobQueryMapper.getStratJobList();
        if (jobInfoPOS != null && jobInfoPOS.size() > 0) {
            jobInfoPOS.stream().forEach(jobInfo -> {
                jobManager.addJob(jobInfo.getJobName(), jobInfo.getJobGroup(), jobInfo.getBeanClass(), jobInfo.getCronExpression());
            });
        }
    }


}