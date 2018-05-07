package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaMenuMapper;
import com.wo.ms.oa.dto.OaMenuDto;
import com.wo.ms.oa.dto.OaMenuPagtionDto;
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
    public int insertMenu(OaMenuDto menuDto) {
        return oaMenuMapper.insertMenu(menuDto);
    }

    @Override
    public OaMenu selectByPrimaryKey(Integer id) {
        return oaMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public OaMenu selectRootMenu() {
        return oaMenuMapper.selectRootMenu();
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
    public List<OaMenu> selectSubMenu(Integer id) {
        return oaMenuMapper.selectSubMenu(id);
    }

    @Override
    public OaMenuPagtionDto selectMenuByKeyPaging(String key, Integer pageSize, Integer currentPage) {
        OaMenuPagtionDto oaMenuPagtionDto = new OaMenuPagtionDto();
        oaMenuPagtionDto.setCurrentPage(currentPage);
        oaMenuPagtionDto.setPageSize(pageSize);
        oaMenuPagtionDto.setMenuList(oaMenuMapper.selectMenusByKeyLimit(key, pageSize, (currentPage - 1) * pageSize));
        oaMenuPagtionDto.setTotalPage((oaMenuMapper.selectMenusByKey(key) - 1) / pageSize + 1);
        return oaMenuPagtionDto;
    }

    @Override
    public int updateByPrimaryKeySelective(OaMenu record) {
        return oaMenuMapper.updateByPrimaryKeySelective(record);
    }
}
