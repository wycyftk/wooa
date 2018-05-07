package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaInfoMapper;
import com.wo.ms.oa.dto.OaInfoPagtionDto;
import com.wo.ms.oa.entity.OaInfo;
import com.wo.ms.oa.services.OaInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OaInfoServiceImpl implements OaInfoService {
    @Resource
    private OaInfoMapper oaInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaInfo record) {
        return oaInfoMapper.insert(record);
    }

    @Override
    public OaInfo selectByPrimaryKey(Integer id) {
        return oaInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OaInfo> selectAllInfos() {
        return oaInfoMapper.selectAllInfos();
    }

    @Override
    public int updateByPrimaryKeySelective(OaInfo record) {
        return oaInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public OaInfoPagtionDto selectInfoPagtionByKey(String key, Integer pageSize, Integer currentPage) {
        OaInfoPagtionDto oaInfoPagtionDto = new OaInfoPagtionDto();
        oaInfoPagtionDto.setCurrentPage(currentPage);
        oaInfoPagtionDto.setPageSize(pageSize);
        oaInfoPagtionDto.setInfoList(oaInfoMapper.selectInfoByKeyLimit(key, pageSize, (currentPage - 1) * pageSize));
        oaInfoPagtionDto.setTotalPage((oaInfoMapper.selectInfoByKey(key) - 1) / pageSize + 1);
        return oaInfoPagtionDto;
    }
}
