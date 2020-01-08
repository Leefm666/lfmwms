package com.lfm.wms.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.lfm.wms.Service.GoodsService;
import com.lfm.wms.model.Customer;
import com.lfm.wms.model.Goods;
import com.lfm.wms.model.SysRole;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lfm
 * @date 2019/12/20 - 17:24
 */
@Controller
@RequestMapping("Goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @ResponseBody
    @RequestMapping("/selectAllGoods2")
    public RetResult<List<Goods>>selectAllGoods(Goods goods ,int page,int limit){
        PageInfo<Goods> pageInfo=goodsService.selectAllGoods(goods, page, limit);
        List<Goods> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
   @ResponseBody
    @RequestMapping("selectAllGoods")
    @RequiresPermissions(value = { "商品管理","进货入库"},logical= Logical.OR)
    public Map<String,Object> list(Goods goods ,int page,int rows)throws Exception{
       System.out.println("goodsname="+goods.getName());
       System.out.println("goods="+goods);
       Map<String,Object> map=new HashMap<>();

       if(goods.getName()!=null){
           map.put("name",goods.getName());

       }
       if(goods.getType()!=null && goods.getType().getId()!=null ){
           map.put("typeid",goods.getType().getId());
           System.out.println("type="+goods.getType().toString());
           System.out.println("typeid="+goods.getType().getId());

       }

        Map<String, Object> resultMap = new HashMap<>();
//        PageInfo<Goods> pageInfo=goodsService.selectAllGoods(goods, page, rows);
       PageInfo<Goods> pageInfo=goodsService.selectAllGoods2(map, page, rows);
        List<Goods> list=pageInfo.getList();
        Long total=pageInfo.getTotal();
        resultMap.put("rows",list);
        resultMap.put("total", total);
        return resultMap;
    }
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions(value = { "商品管理","进货入库"},logical=Logical.OR)
    public Map<String,Object> save(Goods goods)throws Exception{
        if(goods.getId()!=null){ // 写入日志
            System.out.println("更新商品");
            goods.setTypeId(goods.getType().getId());
            goodsService.updateGoods(goods);
        }else{
            System.out.println("插入商品");
            goods.setTypeId(goods.getType().getId());
            goods.setLastPurchasingPrice(goods.getPurchasingPrice()); // 设置上次进价为当前价格
            goodsService.insertGoods(goods);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("success", true);
        return resultMap;
    }
    @ResponseBody
    @RequestMapping("/genGoodsCode")
    public String genGoodsCode(){
        String maxGoodsCode=goodsService.getMaxCode();

        if(StringUtil.isNotEmpty(maxGoodsCode)){
            String[] a =maxGoodsCode.split("\\.");
            Integer code=Integer.valueOf(a[0]);
            String codes=code.toString();
            int length=codes.length();
            for (int i=4;i>length;i--){
                codes="0"+codes;
            }
            return codes;
        }else
            return "0001";
    }
    @ResponseBody
    @RequestMapping("/delete")
    public Map<String,Object>delete(Integer id){
        Map<String,Object>resultMap=new HashMap<>();
        Goods goods=goodsService.findById(id);
        if(goods.getState()==1){
            resultMap.put("success",false);
            resultMap.put("errorInfo","该商品已经期初入库，不能删除");

        }else if(goods.getState()==2){// 2表示有进货或者销售单据 不能删除
            resultMap.put("success",false);
            resultMap.put("errorInfo","该商品已经发生单据，不能删除");
        }else{
            goodsService.deleteGoods(id);
            resultMap.put("success",true);

        }
        return resultMap;
    }
    @ResponseBody
    @RequestMapping("selectAllGoods3")
    public  RetResult<List<Goods>>selectAllGoods3(Goods goods,int page,@RequestParam("limit") int rows){
        PageInfo<Goods> pageInfo=goodsService.selectAllGoods(goods,page,rows);
        List<Goods> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }

}
