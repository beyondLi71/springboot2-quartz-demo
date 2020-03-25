package com.beyondli.repository.test;

import com.beyondli.entity.po.test.AddUserInfoPO;
import com.beyondli.entity.po.test.UserInfoPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by beyondLi
 * Date 2019/6/4 14:19
 * Desc .
 */
public interface TestCUDMapper {

    /**
     * 新增用户信息
     * @param addUserInfoPO
     */
    @Insert("INSERT INTO user_info (id, name, age) VALUES (#{id},#{name}, #{age})")
    void addInfo(AddUserInfoPO addUserInfoPO);
}
