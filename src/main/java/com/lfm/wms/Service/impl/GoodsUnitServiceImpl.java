package com.lfm.wms.Service.impl;

import com.lfm.wms.Service.GoodsService;
import com.lfm.wms.Service.GoodsUnitService;
import com.lfm.wms.dao.GoodsUnitMapper;
import com.lfm.wms.model.GoodsUnit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/21 - 16:57
 */
@Service
public class GoodsUnitServiceImpl implements GoodsUnitService {
    @Resource
    private GoodsUnitMapper goodsUnitMapper;
    @Override
    public List<GoodsUnit> selectAllGoodsUnit() {
        return goodsUnitMapper.selectAllGoodsUnit();
    }

    @Override
    public List<GoodsUnit> selctAllGoodsUnitName() {
        return goodsUnitMapper.selctAllGoodsUnitName();
    }

    @Override
    public void addGoodsUnit(GoodsUnit goodsUnit) {
        goodsUnitMapper.addGoodsUnit(goodsUnit);
    }

    @Override
    public void deleteGoodsUnit(Integer id) {
        goodsUnitMapper.deleteGoodsUnit(id);
    }
}
