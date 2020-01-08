package com.lfm.wms.Service;



import com.lfm.wms.model.SysPermissionInit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Description: SysPermissionInitService接口
* @author 张瑶
* @date 2018/05/18 14:37
*/
public interface SysPermissionInitService  {

    List<SysPermissionInit> selectAllOrderBySort();
    void updatepermurl(@Param("string") String string, @Param("url") String url);
    Integer insertpermurl(SysPermissionInit sysPermissionInit);
    void deletepermission(@Param("perinitid") String perinitid);
}