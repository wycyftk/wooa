package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaCar;

public interface OaCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaCar record);

    OaCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaCar record);
}