package com.lfm.wms.dao;



import com.lfm.wms.model.SysPermissionInit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPermissionInitMapper  {
    List<SysPermissionInit> selectAllOrderBySort();
    void updatepermurl(@Param("string") String string, @Param("url") String url);
    Integer insertpermurl(SysPermissionInit sysPermissionInit);
    void deletepermission(@Param("perinitid") String perinitid);
}