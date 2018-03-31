package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaRoleMapper;
import com.wo.ms.oa.entity.OaRole;
import com.wo.ms.oa.services.OaRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OaRoleServiceImpl implements OaRoleService {
    @Resource
    private OaRoleMapper oaRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaRole record) {
        return oaRoleMapper.insert(record);
    }

    @Override
    public OaRole selectByPrimaryKey(Integer id) {
        return oaRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OaRole record) {
        return oaRoleMapper.updateByPrimaryKeySelective(record);
    }
}
