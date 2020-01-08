package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.GoodsService;
import com.lfm.wms.dao.GoodsMapper;
import com.lfm.wms.model.Goods;
import com.lfm.wms.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/12/20 - 17:11
 */@Service
public class GoodsServiceImpl implements GoodsService {
     @Resource
     private GoodsMapper goodsMapper;
    @Override
    public PageInfo<Goods> selectAllGoods(Goods goods, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<Goods> list =goodsMapper.selectAllGoods(goods);
        //生成PageInfo对象
        PageInfo<Goods> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Goods> selectAllGoods2(Map<String, Object> map, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<Goods> list =goodsMapper.selectAllGoods2(map);
        //生成PageInfo对象
        PageInfo<Goods> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void insertGoods(Goods goods) {
        goodsMapper.insertGoods(goods);
    }

    @Override
    public String getMaxCode() {
        return goodsMapper.getMaxCode();
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsMapper.updateGoods(goods);
    }

    @Override
    public void deleteGoods(Integer id) {
        goodsMapper.deleteGoods(id);
    }

    @Override
    public Goods findById(Integer id) {
        return goodsMapper.findById(id);
    }
}
