package com.lfm.wms.controller;

import com.lfm.wms.Service.GoodsUnitService;
import com.lfm.wms.model.GoodsUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/12/21 - 16:59
 */
@Controller
@RequestMapping("GoodsUnit")
public class GoodsUnitController {
    @Autowired
    private GoodsUnitService goodsUnitService;
    @ResponseBody
    @RequestMapping("/comboList")
    public List<GoodsUnit> comboList(){
       return goodsUnitService.selectAllGoodsUnit();
    }
    @ResponseBody
    @RequestMapping("/listAll")
    public Map<String,Object> listAll(){
        List<GoodsUnit> goodsUnitList=goodsUnitService.selectAllGoodsUnit();
        Map<String,Object>resultMap=new HashMap<>();
        resultMap.put("rows",goodsUnitList);
        return resultMap;
    }
    @ResponseBody
    @RequestMapping("save")
    public Map<String,Object> save(GoodsUnit goodsUnit)throws Exception{
        Map<String, Object> resultMap = new HashMap<>();
        goodsUnitService.addGoodsUnit(goodsUnit);
        resultMap.put("success", true);
        return resultMap;
    }
    @ResponseBody
    @RequestMapping("/delete")
    public Map<String,Object>delete(Integer id){
        Map<String,Object> resultMap=new HashMap<>();
        goodsUnitService.deleteGoodsUnit(id);
        resultMap.put("success",true);
        return  resultMap;
    }
}
