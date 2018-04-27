package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaMenu;

import java.util.List;

public interface OaMenuService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMenu record);

    OaMenu selectByPrimaryKey(Integer id);

    List<OaMenu> selectAllMenus();

    List<OaMenu> selectMenusByLevel(Integer level);

    int updateByPrimaryKeySelective(OaMenu record);
}
