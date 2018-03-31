package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaRole;

public interface OaRoleService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaRole record);

    OaRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OaRole record);
}
