package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaMenuMapper;
import com.wo.ms.oa.entity.OaMenu;
import com.wo.ms.oa.services.OaMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OaMenuServiceImpl implements OaMenuService {
    @Resource
    private OaMenuMapper oaMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaMenu record) {
        return oaMenuMapper.insert(record);
    }

    @Override
    public OaMenu selectByPrimaryKey(Integer id) {
        return oaMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OaMenu> selectAllMenus() {
        return oaMenuMapper.selectAllMenus();
    }

    @Override
    public List<OaMenu> selectMenusByLevel(Integer level) {
        return oaMenuMapper.selectMenusByLevel(level);
    }

    @Override
    public int updateByPrimaryKeySelective(OaMenu record) {
        return oaMenuMapper.updateByPrimaryKeySelective(record);
    }
}
