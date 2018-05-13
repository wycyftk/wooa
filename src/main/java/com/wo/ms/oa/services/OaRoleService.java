package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaRole;
import com.wo.ms.oa.dto.OaRolePagtionDto;
import com.wo.ms.oa.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OaRoleService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaRole record);

    OaRole selectByPrimaryKey(Integer id);

    OaRolePagtionDto selectByKeyPaging(String key, Integer pageSize, Integer currentPage);

    int updateByPrimaryKeySelective(OaRole record);

    int assginRole(UserRole userRole);

    int delUserRole(Integer userId);

    List<Map<String, Object>> selectUserRole(Integer userId);
}
