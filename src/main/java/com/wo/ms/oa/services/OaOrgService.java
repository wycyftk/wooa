package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaOrgDto;
import com.wo.ms.oa.entity.OaOrg;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface OaOrgService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaOrgDto record);

    OaOrg selectByPrimaryKey(Integer id);

    OaOrg selectRootOrg();

    List<OaOrg> selectOrgByLevel(Integer level, Integer parentId);

    List<OaOrg> selectAllOrg();

    List<OaOrg> selectSubOrg(Integer id);

    List<OaOrg> selectOrgsByLevel(Integer level);

    int updateByPrimaryKeySelective(OaOrg record);
}
