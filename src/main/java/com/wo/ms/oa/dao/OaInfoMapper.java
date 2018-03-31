package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OaInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaInfo record);

    OaInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaInfo record);
}