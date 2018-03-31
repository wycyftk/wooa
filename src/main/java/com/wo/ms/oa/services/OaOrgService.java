package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaOrg;

public interface OaOrgService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaOrg record);

    OaOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaOrg record);
}
