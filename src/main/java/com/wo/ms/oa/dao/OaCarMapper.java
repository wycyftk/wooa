package com.wo.ms.oa.dao;

import com.wo.ms.oa.entity.OaCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OaCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OaCar record);

    OaCar selectByPrimaryKey(Integer id);

    List<OaCar> selectCarByKeyLimit(@Param("key") String key, @Param("pageSize") Integer pageSize, @Param("start") Integer start);

    List<OaCar> selectCanUseCar();

    Integer selectCarByKey(@Param("key") String key);

    int updateByPrimaryKeySelective(OaCar record);
}