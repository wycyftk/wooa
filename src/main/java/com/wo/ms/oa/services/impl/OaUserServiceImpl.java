package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaUserMapper;
import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.services.OaUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OaUserServiceImpl implements OaUserService{
    @Resource
    private OaUserMapper oaUserMapper;

    @Override
    public OaUser selectOaUser() {
        return oaUserMapper.selectByPrimaryKey(1);
    }
}
