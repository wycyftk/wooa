package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaMenu;

public interface OaMenuService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMenu record);

    OaMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaMenu record);
}
