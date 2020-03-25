package com.beyondli.controller.job;

import com.beyondli.common.utils.apiresult.AbstractApiResult;
import com.beyondli.common.utils.page.PageParam;
import com.beyondli.common.utils.page.PageResult;
import com.beyondli.entity.dto.job.AddJobDTO;
import com.beyondli.entity.dto.job.ManagerJobDTO;
import com.beyondli.entity.dto.test.AddUserInfoDTO;
import com.beyondli.service.job.JobService;
import com.beyondli.service.test.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:10
 * Desc .
 */
@RestController
@Api(value = "job", tags = {"job任务demo"})
@RequestMapping(value = "/job")
public class JobController {

    @Resource
    JobService jobService;

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    @ApiOperation(value = "启动任务(立即执行一次某任务)", produces = "application/json")
    public AbstractApiResult start(@RequestBody ManagerJobDTO managerJobDTO) {
        jobService.start(managerJobDTO);
        return AbstractApiResult.success("ok");
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    @ApiOperation(value = "停止任务", produces = "application/json")
    public AbstractApiResult stop(@RequestBody ManagerJobDTO managerJobDTO) {
        jobService.stop(managerJobDTO);
        return AbstractApiResult.success("ok");
    }

    @RequestMapping(value = "/recover", method = RequestMethod.POST)
    @ApiOperation(value = "恢复任务", produces = "application/json")
    public AbstractApiResult recover(@RequestBody ManagerJobDTO managerJobDTO) {
        jobService.recover(managerJobDTO);
        return AbstractApiResult.success("ok");
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(value = "删除任务", produces = "application/json")
    public AbstractApiResult del(@RequestBody ManagerJobDTO managerJobDTO) {
        jobService.del(managerJobDTO);
        return AbstractApiResult.success("ok");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增任务(需要先编写对应Job，可与数据库、自启动运行配合已达到动态配置)", produces = "application/json")
    public AbstractApiResult add(@RequestBody AddJobDTO addJobDTO) {
        jobService.add(addJobDTO);
        return AbstractApiResult.success("ok");
    }
}
