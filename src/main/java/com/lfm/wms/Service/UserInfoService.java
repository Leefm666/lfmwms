package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.UserInfo;

/**
 * @author lfm
 * @date 2019/11/12 - 20:07
 */
public interface UserInfoService {

    UserInfo selectById(Integer id);
    UserInfo selectByName(String username);
//    UserInfo getAllUser();
    PageInfo<UserInfo> getAllUser(Integer page,Integer size);
    void updateUser(UserInfo userInfo);
    void deleteUser(Integer id);
    PageInfo<UserInfo> getAll(UserInfo userInfo,int page,int size);
    void addUser(UserInfo userInfo);
}
