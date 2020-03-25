package com.beyondli.common.tools.job;

import lombok.extern.log4j.Log4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@DisallowConcurrentExecution //作业不并发
@Component
@Log4j
public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext job) {
        System.out.println("测试定时器" + LocalDateTime.now() + job.getJobDetail());
    }
}
