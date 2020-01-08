package com.lfm.wms.Service;

import java.util.Map;

/**
 * @author lfm
 * @date 2019/11/27 - 11:02
 */
public interface ShiroService {

    Map<String, String> loadFilterChainDefinitions();

    /**
     * 动态修改权限
     */
    void updatePermission();
}

