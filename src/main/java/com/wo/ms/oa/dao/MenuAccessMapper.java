package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.MenuAccess;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuAccessMapper {
    int deleteByPrimaryKey(MenuAccess key);

    int insert(MenuAccess record);

    int insertSelective(MenuAccess record);
}