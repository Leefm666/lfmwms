package com.lfm.wms.Service;

import com.lfm.wms.model.GoodStype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/19 - 11:28
 */
public interface GoodStypeService {
    List<GoodStype> findByParentId(@Param("parentId") int parentId);
    GoodStype fingById(@Param("id") Integer id);
    void save(GoodStype goodStype);
    void delete(@Param("id") Integer id);
    void insert(GoodStype goodStype);
}
