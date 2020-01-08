package com.lfm.wms.dao;

import com.lfm.wms.model.Action;
import org.apache.ibatis.annotations.Param;

/**
 * @author lfm
 * @date 2019/12/17 - 9:40
 */
public interface ActionPermMapper {
    void insertpermroid(@Param("actionid") String actionid , @Param("perminitid") String perminitid);
    String selectPerInitId(Action action);
    void deleteActionPerm(Action action);
}
