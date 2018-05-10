package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaCarPagtionDto;
import com.wo.ms.oa.entity.OaCar;

import java.util.List;

public interface OaCarService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaCar record);

    OaCar selectByPrimaryKey(Integer id);

    OaCarPagtionDto selectCarByKeyPation(String key, Integer pageSize, Integer currentPage);

    List<OaCar> selectCanUseCar();

    int updateByPrimaryKeySelective(OaCar record);
}
