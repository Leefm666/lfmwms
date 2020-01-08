package com.lfm.wms.Service.impl;

import com.lfm.wms.Service.GoodStypeService;
import com.lfm.wms.dao.GoodStypeMapper;
import com.lfm.wms.model.GoodStype;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/19 - 11:28
 */@Service
public class GoodStypeServiceImpl implements GoodStypeService {
     @Resource
     private GoodStypeMapper stypeMapper;
    @Override
    public List<GoodStype> findByParentId(int parentId) {
        return stypeMapper.findByParentId(parentId);
    }

    @Override
    public GoodStype fingById(Integer id) {
        return stypeMapper.fingById(id);
    }

    @Override
    public void save(GoodStype goodStype) {
        stypeMapper.save(goodStype);
    }

    @Override
    public void delete(Integer id) {
        stypeMapper.delete(id);
    }

    @Override
    public void insert(GoodStype goodStype) {
        stypeMapper.insert(goodStype);
    }
}
