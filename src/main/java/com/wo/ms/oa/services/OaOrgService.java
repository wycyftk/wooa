package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaOrgDto;
import com.wo.ms.oa.dto.OaOrgPagtionDto;
import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.entity.UserOrg;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

public interface OaOrgService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaOrgDto record);

    OaOrg selectByPrimaryKey(Integer id);

    OaOrg selectRootOrg();

    List<OaOrg> selectOrgByLevel(Integer level, Integer parentId);

    OaOrgPagtionDto selectAllOrg(String key, Integer pageSize, Integer currentSize);

    List<OaOrg> selectSubOrg(Integer id);

    List<OaOrg> selectOrgsByLevel(Integer level);

    List<Map<String, Object>> selectOrgByUserId(Integer userId);

    List<Integer> selectUserOrgId(Integer userId);

    List<Map<Integer, String>> selectOrgNameByIds(List<Integer> orgIds);

    int deleteUserOrg(Integer userId);

    int assignOrg(UserOrg userOrg);

    int updateByPrimaryKeySelective(OaOrg record);
}
