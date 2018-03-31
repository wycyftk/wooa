package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.MenuAccessMapper;
import com.wo.ms.oa.entity.MenuAccess;
import com.wo.ms.oa.services.MenuAccessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MenuAccessServiceImpl implements MenuAccessService {
    @Resource
    private MenuAccessMapper menuAccessMapper;

    @Override
    public int deleteByPrimaryKey(MenuAccess key) {
        return menuAccessMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(MenuAccess record) {
        return menuAccessMapper.insert(record);
    }

    @Override
    public int insertSelective(MenuAccess record) {
        return menuAccessMapper.insertSelective(record);
    }
}
