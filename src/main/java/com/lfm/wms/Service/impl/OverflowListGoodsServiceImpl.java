package com.lfm.wms.Service.impl;

import com.lfm.wms.Service.OverFlowListService;
import com.lfm.wms.Service.OverflowListGoodsService;
import com.lfm.wms.dao.OverFlowGoodsListMapper;
import com.lfm.wms.dao.OverFlowListMapper;
import com.lfm.wms.model.OverflowListGoods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2020/1/7 - 21:06
 */
@Service
public class OverflowListGoodsServiceImpl implements OverflowListGoodsService {
    @Resource
    private OverFlowGoodsListMapper overFlowGoodsListMapper;
    @Override
    public void insertOverFlowGoodsList(List<OverflowListGoods> overflowListGoods) {
       overFlowGoodsListMapper.insertOverFlowGoodsList(overflowListGoods);
    }
}
