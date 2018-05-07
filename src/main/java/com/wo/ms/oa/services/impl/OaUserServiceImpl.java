package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaUserMapper;
import com.wo.ms.oa.dto.OaUserPagtionDto;
import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.entity.UserOrg;
import com.wo.ms.oa.services.OaUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OaUserServiceImpl implements OaUserService{
    @Resource
    private OaUserMapper oaUserMapper;

    @Override
    public OaUser selectOaUser(Integer userId) {
        return oaUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<OaUser> selectOaUserByKey(String key) {
        return oaUserMapper.selectOaUserByKey(key);
    }

    @Override
    public OaUserPagtionDto selectOaUserPagtion(String key, Integer pageSize, Integer currentPage) {
        OaUserPagtionDto oaUserPagtionDto = new OaUserPagtionDto();
        oaUserPagtionDto.setCurrentPage(currentPage);
        oaUserPagtionDto.setPageSize(pageSize);
        oaUserPagtionDto.setUserList(oaUserMapper.selectOaUserByKeyLimit(key, pageSize, (currentPage - 1) * pageSize));
        oaUserPagtionDto.setTotalPage((oaUserMapper.selectOaUserByKey(key).size() - 1) / pageSize + 1);
        return oaUserPagtionDto;
    }

    @Override
    public Integer checkUser(String username, String password) {
        OaUser user = oaUserMapper.selectUserByUsername(username);
        if(password.equals(user.getPassword())){
            return user.getId();
        }else {
            return -1;
        }
    }

    @Override
    public Integer addOaUser(OaUser oaUser) {
        try{
            OaUser user = oaUserMapper.selectUserByUsername(oaUser.getUsername());
            if(user == null){
                int insertNum = oaUserMapper.insert(oaUser);
                if(insertNum > 0){
                    return oaUser.getId();
                }
            }else{
                return -1;
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Integer updateOaUser(OaUser oaUser) {
        try{
            int updateNum = oaUserMapper.updateByPrimaryKeySelective(oaUser);
            if(updateNum > 0){
                return oaUser.getId();
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Integer deleteOaUser(Integer userId) {
        try{
            return oaUserMapper.deleteByPrimaryKey(userId);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Integer selectOrgIdByUserId(Integer userId) {
        return oaUserMapper.selectOrgIdByUserId(userId);
    }
}
