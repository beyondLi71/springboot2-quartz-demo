package com.beyondli.service.test;

import com.beyondli.common.utils.page.PageParam;
import com.beyondli.common.utils.page.PageResult;
import com.beyondli.entity.dto.test.AddUserInfoDTO;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:14
 * Desc .
 */
@Validated
public interface TestService {
    /**
     * 查看用户信息
     * @param pageParam
     * @return
     */
    PageResult getInfo(PageParam pageParam);

    /**
     * 测试异常
     */
    void errInfo();

    /**
     * 新增用户信息
     * @param addUserInfoDTO
     */
    void addInfo(@Valid AddUserInfoDTO addUserInfoDTO);
}
