package com.lfm.wms.Service;

import com.lfm.wms.model.GoodsUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/21 - 16:56
 */
public interface GoodsUnitService {
    List<GoodsUnit> selectAllGoodsUnit();
    List<GoodsUnit> selctAllGoodsUnitName();
    void addGoodsUnit(GoodsUnit goodsUnit);
    void deleteGoodsUnit(@Param("id") Integer id);
}
