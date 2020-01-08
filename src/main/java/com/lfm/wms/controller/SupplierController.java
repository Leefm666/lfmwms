package com.lfm.wms.controller;

import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.SupplierService;
import com.lfm.wms.model.Supplier;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lfm
 * @date 2019/12/18 - 10:03
 */
@Controller
@RequestMapping("Supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @ResponseBody
    @RequestMapping("selectAllSupplier")
    public RetResult<List<Supplier>>selectAllSupplier(Supplier supplier ,int page,int limit){
        PageInfo<Supplier> pageInfo=supplierService.selectAllSupplier(supplier,page,limit);
        List<Supplier> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
    @ResponseBody
    @RequestMapping("updateSupplier")
    public RetResult<Object>updateSupplier(Supplier supplier){
        supplierService.updateSupplier(supplier);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("deleteSupplier")
    public RetResult<Object> deleteSupplier(Supplier supplier){
        supplierService.deleteSupplier(supplier);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("addSupplier")
    public RetResult<Object> addSupplier(Supplier supplier){
        supplierService.addSupplier(supplier);
        return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Supplier> selectAll(){
        return supplierService.selectAll();
    }
}
