package com.wo.ms.oa.dao;

import com.wo.ms.oa.dto.OaOrgDto;
import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.entity.UserOrg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OaOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaOrgDto record);

    OaOrg selectByPrimaryKey(Integer id);

    OaOrg selectRootOrg();

    List<OaOrg> selectOrgByLevel(@Param("level") Integer level,@Param("parentId") Integer parentId);

    List<OaOrg> selectAllOrg(@Param("key") String key, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    Integer getAllOrgCount(@Param("key") String key);

    List<OaOrg> selectSubOrg(Integer id);

    List<OaOrg> selectOrgsByLevel(Integer level);

    List<Map<String, Object>> selectOrgByUserId(@Param("userId") Integer userId);

    int deleteUserOrg(@Param("userId") Integer userId);

    int updateByPrimaryKeySelective(OaOrg record);

    int insertUserOrg(UserOrg userOrg);

    int delUserOrg(UserOrg userOrg);
}