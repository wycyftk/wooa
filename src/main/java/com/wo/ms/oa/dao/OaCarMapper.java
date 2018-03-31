package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaCar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OaCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaCar record);

    OaCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaCar record);
}