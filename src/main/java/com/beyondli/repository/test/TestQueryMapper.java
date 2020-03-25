package com.beyondli.repository.test;

import com.beyondli.entity.po.test.UserInfoPO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:19
 * Desc .
 */
public interface TestQueryMapper {
    /**
     * 查看用户信息
     * @return
     */
    @Select("select id, name, age from user_info")
    List<UserInfoPO> getInfo();
}
