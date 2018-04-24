package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaOrg;

import java.util.List;

public interface OaOrgService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaOrg record);

    OaOrg selectByPrimaryKey(Integer id);

    List<OaOrg> selectOrgByLevel(Integer level, Integer parentId);

    List<OaOrg> selectAllOrg();

    List<OaOrg> selectSubOrg(Integer id);

    int updateByPrimaryKeySelective(OaOrg record);
}
