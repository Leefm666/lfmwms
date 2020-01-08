package com.lfm.wms.Service;

import com.lfm.wms.model.Action;
import org.apache.ibatis.annotations.Param;

/**
 * @author lfm
 * @date 2019/12/17 - 9:58
 */
public interface ActionPermService {
    void insertpermroid(@Param("actionid") String actionid , @Param("perminitid") String perminitid);
    String selectPerInitId(Action action);
    void deleteActionPerm(Action action);
}
