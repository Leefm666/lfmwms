package com.lfm.wms.controller;

import com.lfm.wms.Service.OverflowListGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lfm
 * @date 2020/1/7 - 21:11
 */
@Controller
@RequestMapping("OverflowListGoods")
public class OverflowListGoodsController {
    @Autowired
    private OverflowListGoodsService overflowListGoodsService;


}
