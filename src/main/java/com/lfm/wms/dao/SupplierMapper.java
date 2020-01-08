package com.lfm.wms.dao;

import com.lfm.wms.model.Supplier;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/18 - 9:48
 */
public interface SupplierMapper {
    List<Supplier> selectAllSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(Supplier supplier);
    void addSupplier(Supplier supplier);
    List<Supplier>selectAll();
}
