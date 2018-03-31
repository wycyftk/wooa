package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaInfo;

public interface OaInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaInfo record);

    OaInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaInfo record);
}
