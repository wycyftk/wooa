package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaOrgMapper;
import com.wo.ms.oa.dto.OaOrgDto;
import com.wo.ms.oa.dto.OaOrgPagtionDto;
import com.wo.ms.oa.entity.OaOrg;
import com.wo.ms.oa.entity.UserOrg;
import com.wo.ms.oa.services.OaOrgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OaOrgServiceImpl implements OaOrgService {
    @Resource
    private OaOrgMapper oaOrgMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaOrgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaOrgDto record) {
        return oaOrgMapper.insert(record);
    }

    @Override
    public OaOrg selectByPrimaryKey(Integer id) {
        return oaOrgMapper.selectByPrimaryKey(id);
    }

    @Override
    public OaOrg selectRootOrg() {
        return oaOrgMapper.selectRootOrg();
    }

    @Override
    public List<OaOrg> selectOrgByLevel(Integer level, Integer parentId) {
        return oaOrgMapper.selectOrgByLevel(level, parentId);
    }

    @Override
    public OaOrgPagtionDto selectAllOrg(String key, Integer pageSize, Integer currentPage) {
        List<OaOrg> orgList = oaOrgMapper.selectAllOrg(key, (currentPage - 1) * pageSize, pageSize);
        OaOrgPagtionDto oaOrgPagtionDto = new OaOrgPagtionDto();
        oaOrgPagtionDto.setCurrentPage(currentPage);
        oaOrgPagtionDto.setPageSize(pageSize);
        oaOrgPagtionDto.setOrgList(orgList);
        oaOrgPagtionDto.setTotalPage((oaOrgMapper.getAllOrgCount(key) - 1) / pageSize + 1);
        return oaOrgPagtionDto;
    }

    @Override
    public List<OaOrg> selectSubOrg(Integer id) {
        return oaOrgMapper.selectSubOrg(id);
    }

    @Override
    public List<OaOrg> selectOrgsByLevel(Integer level) {
        return oaOrgMapper.selectOrgsByLevel(level);
    }

    @Override
    public List<Map<String, Object>> selectOrgByUserId(Integer userId) {
        return oaOrgMapper.selectOrgByUserId(userId);
    }

    @Override
    public List<Integer> selectUserOrgId(Integer userId) {
        return oaOrgMapper.selectUserOrgId(userId);
    }

    @Override
    public int deleteUserOrg(Integer userId) {
        return oaOrgMapper.deleteUserOrg(userId);
    }

    @Override
    public int assignOrg(UserOrg userOrg) {
        return oaOrgMapper.insertUserOrg(userOrg);
    }

    @Override
    public int updateByPrimaryKeySelective(OaOrg record) {
        return oaOrgMapper.updateByPrimaryKeySelective(record);
    }
}
