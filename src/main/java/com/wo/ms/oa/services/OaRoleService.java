package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaRole;
import com.wo.ms.oa.vo.OaRoleVo;

import java.util.List;

public interface OaRoleService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaRole record);

    OaRole selectByPrimaryKey(Integer id);

    OaRoleVo selectByKeyPaging(String key, Integer pageSize, Integer currentPage);

    int updateByPrimaryKeySelective(OaRole record);
}
