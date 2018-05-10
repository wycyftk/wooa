package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaOrgMapper;
import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.entity.UserOrg;
import com.wo.ms.oa.services.OaOrgService;
import com.wo.ms.oa.services.UserOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserOrgServiceImpl implements UserOrgService {
    @Resource
    private OaOrgMapper oaOrgMapper;

    @Override
    public int insert(UserOrg userOrg) {
        return oaOrgMapper.insertUserOrg(userOrg);
    }

    public int delete(UserOrg userOrg){
        return oaOrgMapper.delUserOrg(userOrg);
    }
}
