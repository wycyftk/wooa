package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaCar;

public interface OaCarService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaCar record);

    OaCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaCar record);
}
