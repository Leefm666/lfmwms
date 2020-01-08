package com.lfm.wms.Service;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.model.Supplier;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/18 - 9:58
 */
public interface SupplierService {
    PageInfo<Supplier> selectAllSupplier(Supplier supplier,int page,int size);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(Supplier supplier);
    void addSupplier(Supplier supplier);
    List<Supplier> selectAll();
}
