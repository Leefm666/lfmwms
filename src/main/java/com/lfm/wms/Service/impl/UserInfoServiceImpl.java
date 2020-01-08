package com.lfm.wms.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfm.wms.Service.UserInfoService;
import com.lfm.wms.dao.UserInfoMapper;
import com.lfm.wms.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lfm
 * @date 2019/11/12 - 20:08
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo selectById(Integer id){
        return userInfoMapper.selectById(id);
    }

    @Override
    public UserInfo selectByName(String username) {
        return userInfoMapper.selectByName( username);
    }

    @Override
    public PageInfo<UserInfo> getAllUser(Integer page, Integer size) {
//        开启分页查询，写在查询语句上方
//        只有紧跟在PageHelper.startPage方法第一个Mybatis的查询（select）方法会被分页
        PageHelper.startPage(page,size);
        List<UserInfo> userInfoList=userInfoMapper.getAllUser();
        PageInfo<UserInfo> pageInfo=new PageInfo<>(userInfoList);
        return pageInfo;
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userInfoMapper.updateUser(userInfo);
    }

    @Override
    public void deleteUser(Integer id) {
        userInfoMapper.deleteUser(id);
    }

    @Override
    public PageInfo<UserInfo> getAll(UserInfo userInfo, int page, int size) {
        // 首先开启PageHelper的分页
        PageHelper.startPage(page, size);
        // 查询分页信息 调用方式与普通方式一致
        List<UserInfo> list = userInfoMapper.selectAll(userInfo);
        //生成PageInfo对象
        PageInfo<UserInfo> pageInfo=new PageInfo<UserInfo>(list);
        return pageInfo;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.addUser(userInfo);
    }


  /*  @Override
    public UserInfo getAllUser() {
        return userInfoMapper.getAllUser();
    }*/
}

