package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaOrgMapper;
import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.services.OaOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OaOrgServiceImpl implements OaOrgService {
    @Resource
    private OaOrgMapper oaOrgMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaOrgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaOrg record) {
        return oaOrgMapper.insert(record);
    }

    @Override
    public OaOrg selectByPrimaryKey(Integer id) {
        return oaOrgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OaOrg record) {
        return oaOrgMapper.updateByPrimaryKeySelective(record);
    }
}