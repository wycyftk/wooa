package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OaRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaRole record);

    OaRole selectByPrimaryKey(Integer id);

    List<OaRole> selectByKeyPaging(@Param("key") String key,@Param("pageSize") Integer pageSize,@Param("start") Integer start);

    List<OaRole> selectByKey(@Param("key") String key);

    int updateByPrimaryKeySelective(OaRole record);
}