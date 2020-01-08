package com.lfm.wms.dao;

import com.lfm.wms.model.Goods;
import com.lfm.wms.model.GoodsUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/21 - 16:51
 */
public interface GoodsUnitMapper {
    List<GoodsUnit> selectAllGoodsUnit();
    List<GoodsUnit> selctAllGoodsUnitName();
    void addGoodsUnit(GoodsUnit goodsUnit);
    void deleteGoodsUnit(@Param("id") Integer id);
}
