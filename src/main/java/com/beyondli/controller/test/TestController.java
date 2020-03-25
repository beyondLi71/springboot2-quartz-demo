package com.beyondli.controller.test;

import com.beyondli.common.utils.apiresult.AbstractApiResult;
import com.beyondli.common.utils.page.PageParam;
import com.beyondli.common.utils.page.PageResult;
import com.beyondli.entity.dto.test.AddUserInfoDTO;
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
@Api(value = "test", tags = {"swagger测试展示"})
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    TestService testService;

    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    @ApiOperation(value = "分页展示", produces = "application/json")
    public PageResult getInfo(@ModelAttribute PageParam pageParam) {
        PageResult pageResult = testService.getInfo(pageParam);
        return pageResult;
    }

    @RequestMapping(value = "/err/info", method = RequestMethod.GET)
    @ApiOperation(value = "异常展示", produces = "application/json")
    public AbstractApiResult errInfo() {
        testService.errInfo();
        return AbstractApiResult.success("ok");
    }

    @RequestMapping(value = "/add/info", method = RequestMethod.POST)
    @ApiOperation(value = "新增展示", produces = "application/json")
    public AbstractApiResult addInfo(@RequestBody AddUserInfoDTO addUserInfoDTO) {
        testService.addInfo(addUserInfoDTO);
        return AbstractApiResult.success("ok");
    }
}
