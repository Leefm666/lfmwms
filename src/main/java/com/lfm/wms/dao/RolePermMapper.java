package com.lfm.wms.dao;



import java.util.List;

public interface RolePermMapper   {
    List<String> getPermsByUserId(Integer userId);
}