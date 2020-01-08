package com.lfm.wms.dao;

import com.lfm.wms.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lfm
 * @date 2019/11/12 - 20:06
 */
public interface UserInfoMapper {

    UserInfo selectById(@Param("id") Integer id);
    UserInfo selectByName(String username);
//    查询所有的用户
    List<UserInfo> getAllUser();
    void updateUser(UserInfo userInfo);
    void deleteUser(Integer id);
    List<UserInfo> selectAll(UserInfo record);
    void addUser(UserInfo userInfo);
}
