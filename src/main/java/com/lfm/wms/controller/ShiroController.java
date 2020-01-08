package com.lfm.wms.controller;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lfm
 * @date 2019/11/19 - 10:15
 */
@Configuration
public class ShiroController {
    @PostMapping("/notRole")
    public void notRole(){
        throw new UnauthenticatedException();
    }
}
