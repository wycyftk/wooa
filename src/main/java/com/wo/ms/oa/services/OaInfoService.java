package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaInfo;

import java.util.List;

public interface OaInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaInfo record);

    OaInfo selectByPrimaryKey(Integer id);

    List<OaInfo> selectAllInfos();

    int updateByPrimaryKeySelective(OaInfo record);
}
