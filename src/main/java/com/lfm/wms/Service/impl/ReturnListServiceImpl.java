package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.ReturnListService;
import com.lfm.wms.dao.ReturnListMapper;
import com.lfm.wms.model.PurchaseList;
import com.lfm.wms.model.ReturnList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/30 - 15:05
 */
@Service
public class ReturnListServiceImpl implements ReturnListService {
    @Resource
    private ReturnListMapper returnListMapper;
    @Override
    public String getTodayMaxReturmListNumber() {
        return returnListMapper.getTodayMaxReturmListNumber();
    }

    @Override
    public void insertReturnList(ReturnList returnList) {
        returnListMapper.insertReturnList(returnList);
    }

    @Override
    public PageInfo<ReturnList> selectAllReturn(ReturnList returnList, int page, int size) {
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<ReturnList> list = returnListMapper.selectAllReturn(returnList);
        //生成PageInfo对象
        PageInfo<ReturnList> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
