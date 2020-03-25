package com.beyondli.service.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.beyondli.common.tools.exception.ExceptionManager;
import com.beyondli.common.utils.mapper.MapperUtils;
import com.beyondli.common.utils.page.PageParam;
import com.beyondli.common.utils.page.PageResult;
import com.beyondli.common.utils.page.PageResultFactory;
import com.beyondli.common.utils.uuid.UUIDUtils;
import com.beyondli.entity.dto.test.AddUserInfoDTO;
import com.beyondli.entity.po.test.AddUserInfoPO;
import com.beyondli.entity.po.test.UserInfoPO;
import com.beyondli.entity.vo.test.UserInfoVO;
import com.beyondli.repository.test.TestCUDMapper;
import com.beyondli.repository.test.TestQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TestServiceImpl implements TestService {

    @Resource
    TestQueryMapper testQueryMapper;

    @Resource
    TestCUDMapper testCUDMapper;

    @Resource
    PageResultFactory pageResultFactory;

    @Resource
    ExceptionManager exceptionManager;

    /**
     * 获取用户分页信息
     * @param pageParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult getInfo(PageParam pageParam) {
        //设置分页
        PageHelper.startPage(pageParam.getP(), pageParam.getC());
        List<UserInfoPO> userInfoPOList = testQueryMapper.getInfo();
        // 取分页信息
        int total = (int) new PageInfo(userInfoPOList).getTotal();
        List<UserInfoVO> userInfoVOS = MapperUtils.mapperList(userInfoPOList, UserInfoVO.class);
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, userInfoVOS);
        return pageResult;
    }

    /**
     * 异常测试
     */
    @Override
    @Transactional(readOnly = true)
    public void errInfo() {
        if (true) {
            throw exceptionManager.createByCode("TEST_0001");
        }
    }

    /**
     * 新增用户信息
     * @param addUserInfoDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addInfo(AddUserInfoDTO addUserInfoDTO) {
        AddUserInfoPO addUserInfoPO = MapperUtils.mapperBean(addUserInfoDTO, AddUserInfoPO.class);
        addUserInfoPO.setId(UUIDUtils.getUUID());
        testCUDMapper.addInfo(addUserInfoPO);
    }
}
