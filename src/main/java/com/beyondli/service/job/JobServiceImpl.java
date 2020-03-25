package com.beyondli.service.job;

import com.beyondli.common.config.job.JobManager;
import com.beyondli.common.tools.exception.ExceptionManager;
import com.beyondli.common.utils.mapper.MapperUtils;
import com.beyondli.common.utils.page.PageParam;
import com.beyondli.common.utils.page.PageResult;
import com.beyondli.common.utils.page.PageResultFactory;
import com.beyondli.common.utils.uuid.UUIDUtils;
import com.beyondli.entity.dto.job.AddJobDTO;
import com.beyondli.entity.dto.job.ManagerJobDTO;
import com.beyondli.entity.dto.test.AddUserInfoDTO;
import com.beyondli.entity.po.job.JobInfoPO;
import com.beyondli.entity.po.test.AddUserInfoPO;
import com.beyondli.entity.po.test.UserInfoPO;
import com.beyondli.entity.vo.test.UserInfoVO;
import com.beyondli.repository.job.JobQueryMapper;
import com.beyondli.repository.test.TestCUDMapper;
import com.beyondli.repository.test.TestQueryMapper;
import com.beyondli.service.test.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.quartz.Job;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:14
 * Desc .
 */
@Service
public class JobServiceImpl implements JobService {


    @Resource
    JobManager jobManager;


    @Override
    public void start(ManagerJobDTO managerJobDTO) {
        //控制线程
        jobManager.runJobNow(managerJobDTO.getJobName(), managerJobDTO.getJobGroup());
        //控制业务数据库(省略)
    }

    @Override
    public void stop(ManagerJobDTO managerJobDTO) {
        //控制线程
        jobManager.pauseJob(managerJobDTO.getJobName(), managerJobDTO.getJobGroup());
        //控制业务数据库(省略)
    }

    @Override
    public void recover(ManagerJobDTO managerJobDTO) {
        //控制线程
        jobManager.resumeJob(managerJobDTO.getJobName(), managerJobDTO.getJobGroup());
        //控制业务数据库(省略)
    }

    @Override
    public void del(ManagerJobDTO managerJobDTO) {
        //控制线程
        jobManager.deleteJob(managerJobDTO.getJobName(), managerJobDTO.getJobGroup());
        //控制业务数据库(省略)
    }

    @Override
    public void add(AddJobDTO addJobDTO) {
        //控制线程
        jobManager.addJob(addJobDTO.getJobName(), addJobDTO.getJobGroup(), addJobDTO.getBeanClass(), addJobDTO.getCronExpression());
        //控制业务数据库(省略)
    }
}
