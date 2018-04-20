package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OaMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaMenu record);

    OaMenu selectByPrimaryKey(Integer id);

    List<OaMenu> selectAllMenus();

    int updateByPrimaryKeySelective(OaMenu record);
}