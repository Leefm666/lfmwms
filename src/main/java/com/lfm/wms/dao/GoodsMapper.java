package com.lfm.wms.dao;

import com.lfm.wms.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/12/20 - 10:54
 */
public interface GoodsMapper {
    List<Goods>selectAllGoods(Goods goods);
    List<Goods>selectAllGoods2(Map<String,Object> map);
    void insertGoods(Goods goods);
    void updateGoods(Goods goods);
    String getMaxCode();
    void deleteGoods(@Param("id") Integer id);
    Goods findById(@Param("id") Integer id);
}
