package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.ReturnListGoodService;
import com.lfm.wms.Service.ReturnListService;
import com.lfm.wms.dao.ReturnListGoodsMapper;
import com.lfm.wms.model.PurchaseListGoods;
import com.lfm.wms.model.ReturnList;
import com.lfm.wms.model.ReturnListGoods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/30 - 17:40
 */
@Service
public class ReturnListGoodServiceImpl implements ReturnListGoodService {
    @Resource
    private ReturnListGoodsMapper returnListGoodsMapper;
    @Override
    public void insertReturnGoods(List<ReturnListGoods> returnListGoodsList) {
        returnListGoodsMapper.insertReturnGoods(returnListGoodsList);
    }

    @Override
    public PageInfo<ReturnListGoods> selectByReturnListId(ReturnList returnList, int page, int size) {
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<ReturnListGoods> list = returnListGoodsMapper.selectByReturnListId(returnList);
        //生成PageInfo对象
        PageInfo<ReturnListGoods> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }


}
