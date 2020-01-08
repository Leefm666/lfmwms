package com.lfm.wms.Service.impl;


import com.lfm.wms.Service.UserRoleService;
import com.lfm.wms.dao.UserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: UserRoleService接口实现类
* @author 张瑶
* @date 2019/10/26 19:05
*/
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;
    public List<String> getRolesByUserId(Integer userId){
        return userRoleMapper.getRolesByUserId(userId);
    }
}
