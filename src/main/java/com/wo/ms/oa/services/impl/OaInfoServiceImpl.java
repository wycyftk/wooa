package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaInfoMapper;
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
}
