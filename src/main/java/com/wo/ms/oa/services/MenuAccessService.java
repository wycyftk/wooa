package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.MenuAccess;

public interface MenuAccessService {
    int deleteByPrimaryKey(MenuAccess key);

    int insert(MenuAccess record);

    int insertSelective(MenuAccess record);
}
