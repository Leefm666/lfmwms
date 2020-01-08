package com.lfm.wms.dao;

import java.util.List;

/**
 * @author lfm
 * @date 2019/11/15 - 17:04
 */
public interface UserRoleMapper {
    List<String> getRolesByUserId(Integer userId);

}
