/*package com.lfm.wms.core.shiro;


import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.mgt.SecurityManager;

*//**
 * @author lfm
 * @date 2019/11/17 - 0:24
 *//*
@Configuration
public class ShiroConfigurer {
    *//**
     * 注入 securityManager
     *//*
   *//* @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        设置登录界面
        shiroFilterFactoryBean.setLoginUrl("/route/login");
//        设置无权限时跳转的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
//       游客，开发权限
        filterChainDefinitionMap.put("/route1/**","anon");
        filterChainDefinitionMap.put("/userInfo/login", "anon");
        filterChainDefinitionMap.put("/userInfo/selectById", "authc, roles[cw]");
//        filterChainDefinitionMap.put("/static/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/fonts/**","anon");
        filterChainDefinitionMap.put("/images/**","anon");
        filterChainDefinitionMap.put("/layui/**","anon");
        filterChainDefinitionMap.put("/layui2/**","anon");
        filterChainDefinitionMap.put("/less/**","anon");
        filterChainDefinitionMap.put("/lib/**","anon");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;

    }*//*
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/route/login");
//        设置无权限时跳转的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        return shiroFilterFactoryBean;
    }
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        chain.addPathDefinition( "/userInfo/selectById", "authc, roles[admin]");
        chain.addPathDefinition( "/logout", "anon");
        chain.addPathDefinition( "/userInfo/selectAll", "anon");
//        chain.addPathDefinition( "/userInfo/login", "anon");

        chain.addPathDefinition( "/**", "authc");
        return chain;
    }


    @Bean
    public CustomRealm customRealm(){
        CustomRealm myShiroRealm = new CustomRealm();
        return myShiroRealm;
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        return securityManager;
    }


}*/
