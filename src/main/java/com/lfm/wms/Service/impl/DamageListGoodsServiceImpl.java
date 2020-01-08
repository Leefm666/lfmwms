package com.lfm.wms.Service.impl;

import com.lfm.wms.Service.DamageListGoodsService;
import com.lfm.wms.dao.DamageListGoodsMapper;
import com.lfm.wms.dao.DamageListMapper;
import com.lfm.wms.model.DamageListGoods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2020/1/5 - 16:16
 */
@Service
public class DamageListGoodsServiceImpl implements DamageListGoodsService {
    @Resource
    private DamageListGoodsMapper damageListGoodsMapper;
    @Override
    public void insertDamageGoods(List<DamageListGoods> damageListGoodsList) {
        damageListGoodsMapper.insertDamageGoods(damageListGoodsList);
    }
}
