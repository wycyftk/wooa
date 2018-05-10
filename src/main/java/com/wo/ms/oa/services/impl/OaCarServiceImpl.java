package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaCarMapper;
import com.wo.ms.oa.dto.OaCarPagtionDto;
import com.wo.ms.oa.entity.OaCar;
import com.wo.ms.oa.services.OaCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OaCarServiceImpl implements OaCarService {
    @Resource
    private OaCarMapper oaCarMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaCarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaCar record) {
        return oaCarMapper.insert(record);
    }

    @Override
    public OaCar selectByPrimaryKey(Integer id) {
        return oaCarMapper.selectByPrimaryKey(id);
    }

    @Override
    public OaCarPagtionDto selectCarByKeyPation(String key, Integer pageSize, Integer currentPage) {
        OaCarPagtionDto oaCarPagtionDto = new OaCarPagtionDto();
        oaCarPagtionDto.setCurrentPage(currentPage);
        oaCarPagtionDto.setPageSize(pageSize);
        oaCarPagtionDto.setCarList(oaCarMapper.selectCarByKeyLimit(key, pageSize, (currentPage - 1) * pageSize));
        oaCarPagtionDto.setTotalPage((oaCarMapper.selectCarByKey(key) - 1) / pageSize + 1);
        return oaCarPagtionDto;
    }

    @Override
    public List<OaCar> selectCanUseCar() {
        return oaCarMapper.selectCanUseCar();
    }

    @Override
    public int updateByPrimaryKeySelective(OaCar record) {
        return oaCarMapper.updateByPrimaryKeySelective(record);
    }
}
