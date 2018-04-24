package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaOrg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OaOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaOrg record);

    OaOrg selectByPrimaryKey(Integer id);

    List<OaOrg> selectOrgByLevel(@Param("level") Integer level,@Param("parentId") Integer parentId);

    List<OaOrg> selectAllOrg();

    List<OaOrg> selectSubOrg(Integer id);

    int updateByPrimaryKeySelective(OaOrg record);
}