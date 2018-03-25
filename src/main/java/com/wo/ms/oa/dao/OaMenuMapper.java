package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaMenu;

public interface OaMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMenu record);

    OaMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaMenu record);
}