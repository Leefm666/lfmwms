package com.lfm.wms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lfm.wms.ret.RetCode;
import com.lfm.wms.ret.RetResult;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lfm
 * @date 2019/11/19 - 10:23
 */
@ControllerAdvice
public class ExceptionController {
    private  final Logger logger =LoggerFactory.getLogger(ExceptionController.class);
    @ExceptionHandler(UnauthenticatedException.class)
    public void page401(HttpServletResponse response, UnauthenticatedException e){
        RetResult<Object> result=new RetResult<>();
        result.setCode(RetCode.UNAUTHORIZED).setMsg("用户为登录").setData(null);
        responseResult(response, result);
    }
    private void responseResult(HttpServletResponse response, RetResult<Object> result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }


}
