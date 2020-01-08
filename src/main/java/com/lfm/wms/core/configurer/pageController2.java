package com.lfm.wms.core.configurer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lfm
 * @date 2019/11/13 - 14:42
 */
@Controller
@RequestMapping("/route1")
public class pageController2 {
    @GetMapping("/{pageName}")
    public String Rout(@PathVariable String pageName){
        return "/"+pageName;
    }
    @GetMapping("/{pageName}/{pageName2}")
    public String Rout(@PathVariable String pageName,@PathVariable String pageName2){
        return "/"+pageName+"/"+pageName2;
    }
    
}
