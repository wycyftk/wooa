package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaInfoPagtionDto;
import com.wo.ms.oa.entity.OaInfo;
import com.wo.ms.oa.entity.UserAndInfo;

import java.util.List;

public interface OaInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(OaInfo record);

    int publishInfo(OaInfo info,  List<Integer> userIds);

    OaInfo selectByPrimaryKey(Integer id);

    List<OaInfo> selectAllInfos();

    int updateByPrimaryKeySelective(OaInfo record);

    Integer selectNoReadInfoNum(Integer userId);

    Integer hasRead(Integer infoId, Integer userId);

    OaInfoPagtionDto selectInfoPagtionByKey(String key, Integer pageSize, Integer currentPage, Integer loginId, List<String> roleCodes);

    OaInfoPagtionDto selectNoticePagtionByKey(String key, Integer pageSize, Integer currentPage, Integer loginId);
}
