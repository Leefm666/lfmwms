package com.lfm.wms.Service;



import java.util.List;

/**
* @Description: UserRoleService接口
* @author 张瑶
* @date 2019/10/26 19:05
*/
public interface UserRoleService   {
    List<String> getRolesByUserId(Integer userId);
}
