package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OaMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMenu record);

    OaMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaMenu record);
}