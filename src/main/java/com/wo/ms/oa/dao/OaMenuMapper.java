package com.wo.ms.oa.dao;

import com.wo.ms.oa.dto.OaMenuDto;
import com.wo.ms.oa.entity.OaMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OaMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMenu record);

    int insertMenu(OaMenuDto menuDto);

    OaMenu selectByPrimaryKey(Integer id);

    OaMenu selectRootMenu();

    List<OaMenu> selectAllMenus();

    List<OaMenu> selectMenusByLevel(Integer level);

    List<OaMenu> selectSubMenu(Integer id);

    List<OaMenu> selectMenusByKeyLimit(@Param("key") String key, @Param("pageSize") Integer pageSize, @Param("start") Integer start);

    Integer selectMenusByKey(@Param("key") String key);

    int updateByPrimaryKeySelective(OaMenu record);
}