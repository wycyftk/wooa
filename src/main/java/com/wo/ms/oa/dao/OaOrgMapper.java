package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaOrg;

public interface OaOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaOrg record);

    OaOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaOrg record);
}