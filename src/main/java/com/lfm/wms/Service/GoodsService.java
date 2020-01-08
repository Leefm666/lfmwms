package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.Goods;
import com.lfm.wms.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/12/20 - 17:09
 */
public interface GoodsService {
    PageInfo<Goods> selectAllGoods(Goods goods, int page, int size);
    PageInfo<Goods> selectAllGoods2(Map<String,Object> map, int page, int size);
    void insertGoods(Goods goods);
    String getMaxCode();
    void updateGoods(Goods goods);
    void deleteGoods(@Param("id") Integer id);
    Goods findById(@Param("id") Integer id);
}
