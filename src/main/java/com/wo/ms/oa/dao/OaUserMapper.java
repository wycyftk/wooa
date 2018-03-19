package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OaUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaUser record);

    int insertSelective(OaUser record);

    OaUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaUser record);

    int updateByPrimaryKey(OaUser record);
}