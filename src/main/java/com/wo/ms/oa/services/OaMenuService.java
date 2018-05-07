package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaMenuDto;
import com.wo.ms.oa.dto.OaMenuPagtionDto;
import com.wo.ms.oa.entity.OaMenu;

import java.util.List;

public interface OaMenuService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMenu record);

    int insertMenu(OaMenuDto menuDto);

    OaMenu selectByPrimaryKey(Integer id);

    OaMenu selectRootMenu();

    List<OaMenu> selectAllMenus();

    List<OaMenu> selectMenusByLevel(Integer level);

    List<OaMenu> selectSubMenu(Integer id);

    OaMenuPagtionDto selectMenuByKeyPaging(String key, Integer pageSize, Integer currentPage);

    int updateByPrimaryKeySelective(OaMenu record);
}
