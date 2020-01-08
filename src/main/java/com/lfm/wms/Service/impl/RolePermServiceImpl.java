package com.lfm.wms.Service.impl;


import com.lfm.wms.Service.RolePermService;
import com.lfm.wms.dao.RolePermMapper;
import com.lfm.wms.model.RolePerm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: RolePermService接口实现类
* @author 张瑶
* @date 2019/10/26 20:00
*/
@Service
public class RolePermServiceImpl implements RolePermService {

    @Resource
    private RolePermMapper rolePermMapper;
    public List<String> getPermsByUserId(Integer userId){
        return rolePermMapper.getPermsByUserId(userId);
    }

}
