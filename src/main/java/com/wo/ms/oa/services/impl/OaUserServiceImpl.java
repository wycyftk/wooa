package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaUserMapper;
import com.wo.ms.oa.entity.OaUser;
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
    public Integer addOaUser(OaUser oaUser) {
        try{
            int insertNum = oaUserMapper.insert(oaUser);
            if(insertNum > 0){
                return oaUser.getId();
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
}
