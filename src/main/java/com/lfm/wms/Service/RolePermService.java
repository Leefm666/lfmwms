package com.lfm.wms.Service;


import java.util.List;

/**
* @Description: RolePermService接口
* @author 张瑶
* @date 2019/10/26 20:00
*/
public interface RolePermService {
    List<String> getPermsByUserId(Integer userId);
}
