package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OaRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaRole record);

    OaRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaRole record);
}