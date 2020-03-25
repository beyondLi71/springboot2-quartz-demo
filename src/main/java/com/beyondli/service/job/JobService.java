package com.beyondli.service.job;

import com.beyondli.common.utils.page.PageParam;
import com.beyondli.common.utils.page.PageResult;
import com.beyondli.entity.dto.job.AddJobDTO;
import com.beyondli.entity.dto.job.ManagerJobDTO;
import com.beyondli.entity.dto.test.AddUserInfoDTO;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:14
 * Desc .
 */
public interface JobService {

    void start(ManagerJobDTO managerJobDTO);

    void stop(ManagerJobDTO managerJobDTO);
    
    void recover(ManagerJobDTO managerJobDTO);

    void del(ManagerJobDTO managerJobDTO);

    void add(AddJobDTO addJobDTO);
}
