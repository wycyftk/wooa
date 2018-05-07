package com.wo.ms.oa.dao;

import com.wo.ms.oa.dto.OaOrgDto;
import com.wo.ms.oa.entity.OaOrg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    int updateByPrimaryKeySelective(OaOrg record);
}