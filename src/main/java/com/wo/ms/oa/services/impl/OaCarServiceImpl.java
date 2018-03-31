package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaCarMapper;
import com.wo.ms.oa.entity.OaCar;
import com.wo.ms.oa.services.OaCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public int updateByPrimaryKeySelective(OaCar record) {
        return oaCarMapper.updateByPrimaryKeySelective(record);
    }
}
