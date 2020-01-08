package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.SupplierService;
import com.lfm.wms.dao.SupplierMapper;
import com.lfm.wms.model.Supplier;
import com.lfm.wms.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2019/12/18 - 10:00
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierMapper supplierMapper;
    @Override
    public PageInfo<Supplier> selectAllSupplier(Supplier supplier, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<Supplier> list = supplierMapper.selectAllSupplier(supplier);
        //生成PageInfo对象
        PageInfo<Supplier> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierMapper.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(Supplier supplier) {
        supplierMapper.deleteSupplier(supplier);
    }

    @Override
    public void addSupplier(Supplier supplier) {
        supplierMapper.addSupplier(supplier);
    }

    @Override
    public List<Supplier> selectAll() {
        return supplierMapper.selectAll();
    }
}
