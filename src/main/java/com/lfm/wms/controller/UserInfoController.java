package com.lfm.wms.controller;

import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lfm.wms.Service.UserInfoService;
import com.lfm.wms.model.UserInfo;
import com.lfm.wms.ret.RetCode;
import com.lfm.wms.ret.RetResponse;
import com.lfm.wms.ret.RetResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Random;


/**
 * @author lfm
 * @date 2019/11/12 - 20:10
 */
@Controller

@RequestMapping("userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;
    @Autowired
    private DefaultKaptcha captchaProducer;
    @ResponseBody
    @PostMapping("/hello")
    public String hello(){
        return "hello SpringBoot";
    }
    /*@ResponseBody
    @PostMapping("/selectById")
    public UserInfo selectById(Integer id){
        return userInfoService.selectById(id);
    }*/
    @PostMapping("/selectById")
    @ResponseBody
    public RetResult<UserInfo> selectById(Integer id){
        UserInfo userInfo = userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }


    @ResponseBody
    @PostMapping("/login")
    public  RetResult<UserInfo> login(String userName,String password,String verity,HttpServletRequest httpServletRequest){
        System.out.println(userName);
        System.out.println(password);
        System.out.println(verity);
        Subject currentUser = SecurityUtils.getSubject();
        try{
            currentUser.login(new UsernamePasswordToken(userName,password));
        }catch (IncorrectCredentialsException i){
            throw  new RuntimeException("密码输入错误");
        }
        String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
        if (!captchaId.equals(verity)) {
            throw  new RuntimeException("错误的验证码");
        }
        UserInfo user = (UserInfo) currentUser.getPrincipal();
        System.out.println(user);
        return RetResponse.makeOKRsp(user);
    }
   /* @ResponseBody
    @PostMapping("/getAllUser")
    public RetResult<UserInfo> getAlUser(){
        UserInfo userInfo=new UserInfo();
        userInfo=userInfoService.getAllUser();
        return RetResponse.makeOKRsp(userInfo);
    }*/
   @ResponseBody
   @RequestMapping("/getAllUser")
    public RetResult< List<UserInfo>>getAllUser(@RequestParam(defaultValue = "0") Integer page,
                                                @RequestParam(defaultValue = "0") Integer limit){
       PageInfo<UserInfo> pageInfo=userInfoService.getAllUser(page,limit);
       List<UserInfo> list=pageInfo.getList();
       return RetResponse.makeOKRsp(list,pageInfo.getTotal());
   }
   @ResponseBody
   @RequestMapping("/updateUser")
    public RetResult<Object> updateUser(UserInfo userInfo){
       userInfoService.updateUser(userInfo);
       return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/deleteUser")
    public RetResult<Object> deleteUser(Integer id){
       userInfoService.deleteUser(id);
       return RetResponse.makeOKRsp();
    }
    @ResponseBody
    @RequestMapping("/getAll")
    public RetResult<List<UserInfo>> getAll(UserInfo userInfo,@RequestParam("limit") int limit,@RequestParam("page") int page) {
        PageInfo<UserInfo> pageInfo=userInfoService.getAll(userInfo, page, limit);
        List<UserInfo> list=pageInfo.getList();
        return RetResponse.makeOKRsp(list,pageInfo.getTotal());
    }
    @ResponseBody
    @RequestMapping("/addUser")
    public RetResult<Object>addUser(UserInfo userInfo){
        String credentials=userInfo.getPassword();
        String hashAlgorithmName = "md5";
        //原密码
//        String credentials = "123456";
        //加密次数
        int hashIterations = 1024;
        //加密盐值，大家可以用生成字符串的方法
//        String hash = "wxKYXuTPST5SG0jMQzVPsg==";
        String hash=getRandomString(24);
        ByteSource credentialsSalt = ByteSource.Util.bytes(hash);
        String password = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations).toHex();
        System.out.println(password);
        userInfo.setPassword(password);
        userInfo.setSalt(hash);
       userInfoService.addUser(userInfo);
       return RetResponse.makeOKRsp();
    }

    public  String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}


