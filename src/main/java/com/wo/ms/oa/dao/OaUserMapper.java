package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OaUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaUser record);

    OaUser selectByPrimaryKey(Integer id);

    OaUser selectUserByUsername(String username);

    List<OaUser> selectOaUserByKey(String key);

    int updateByPrimaryKeySelective(OaUser record);
}