package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OaUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaUser record);

    OaUser selectByPrimaryKey(Integer id);

    List<OaUser> selectOaUserByKeyLimit(@Param("key") String key,@Param("pageSize") Integer pageSize, @Param("start") Integer start);

    OaUser selectUserByUsername(String username);

    List<OaUser> selectOaUserByKey(@Param("key") String key);

    int updateByPrimaryKeySelective(OaUser record);

    Integer selectOrgIdByUserId(Integer userId);
}