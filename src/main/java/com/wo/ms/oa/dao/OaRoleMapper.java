package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaRole;
import com.wo.ms.oa.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OaRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaRole record);

    OaRole selectByPrimaryKey(Integer id);

    List<OaRole> selectByKeyPaging(@Param("key") String key,@Param("pageSize") Integer pageSize,@Param("start") Integer start);

    List<OaRole> selectByKey(@Param("key") String key);

    List<Map<String, Object>> selectUserRole(@Param("userId") Integer userId);

    List<String> selectUserRoleCode(@Param("userId")Integer userId);

    int assginRole(UserRole userRole);

    int delUserRole(@Param("userId") Integer userId);

    int updateByPrimaryKeySelective(OaRole record);
}