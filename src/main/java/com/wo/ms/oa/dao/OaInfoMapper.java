package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaInfo;
import com.wo.ms.oa.entity.UserAndInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OaInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaInfo record);

    OaInfo selectByPrimaryKey(Integer id);

    List<OaInfo> selectAllInfos();

    int updateByPrimaryKeySelective(OaInfo record);

    List<OaInfo> selectInfoByKeyLimit(@Param("key") String key, @Param("pageSize") Integer pageSize, @Param("start") Integer start);

    Integer selectInfoByKey(@Param("key") String key);

    Integer selectNoReadInfoNum(@Param("userId") Integer userId);

    Integer insertUserAndInfo(@Param("userAndInfos") List<UserAndInfo> userAndInfos);
}