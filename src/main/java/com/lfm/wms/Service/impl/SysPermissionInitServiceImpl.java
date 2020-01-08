package com.lfm.wms.Service.impl;


import com.lfm.wms.Service.SysPermissionInitService;
import com.lfm.wms.dao.SysPermissionInitMapper;
import com.lfm.wms.model.SysPermissionInit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SysPermissionInitService接口实现类
* @author 张瑶
* @date 2018/05/18 14:37
*/
@Service
public class SysPermissionInitServiceImpl  implements SysPermissionInitService {

    @Resource
    private SysPermissionInitMapper sysPermissionInitMapper;

    @Override
    public List<SysPermissionInit> selectAllOrderBySort(){
        return sysPermissionInitMapper.selectAllOrderBySort();
    }

    @Override
    public void updatepermurl(String string, String url) {
        sysPermissionInitMapper.updatepermurl(string,url);
    }

    @Override
    public Integer insertpermurl(SysPermissionInit sysPermissionInit) {
       return sysPermissionInitMapper.insertpermurl(sysPermissionInit);
    }

    @Override
    public void deletepermission(String perinitid) {
        sysPermissionInitMapper.deletepermission(perinitid);
    }

}