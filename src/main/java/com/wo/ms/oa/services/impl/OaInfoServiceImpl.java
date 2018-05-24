package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaInfoMapper;
import com.wo.ms.oa.dto.OaInfoPagtionDto;
import com.wo.ms.oa.entity.OaInfo;
import com.wo.ms.oa.entity.UserAndInfo;
import com.wo.ms.oa.services.OaInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OaInfoServiceImpl implements OaInfoService {
    @Resource
    private OaInfoMapper oaInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaInfo record) {
        return oaInfoMapper.insert(record);
    }

    @Override
    public int publishInfo(OaInfo info, List<Integer> userIds) {
        oaInfoMapper.insert(info);
        List<UserAndInfo> userAndInfos = new ArrayList<>();
        for(int i = 0;i < userIds.size(); i++){
            UserAndInfo userAndInfo = new UserAndInfo();
            userAndInfo.setInfoId(info.getId());
            userAndInfo.setHasRead(0);
            userAndInfo.setUserId(userIds.get(i));
            userAndInfos.add(userAndInfo);
        }
        oaInfoMapper.insertUserAndInfo(userAndInfos);
        return 1;
    }

    @Override
    public OaInfo selectByPrimaryKey(Integer id) {
        return oaInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OaInfo> selectAllInfos() {
        return oaInfoMapper.selectAllInfos();
    }

    @Override
    public int updateByPrimaryKeySelective(OaInfo record) {
        return oaInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Integer selectNoReadInfoNum(Integer userId) {
        return oaInfoMapper.selectNoReadInfoNum(userId);
    }

    @Override
    public Integer hasRead(Integer infoId, Integer userId) {
        return oaInfoMapper.hasRead(infoId, userId);
    }

    @Override
    public OaInfoPagtionDto selectInfoPagtionByKey(String key, Integer pageSize, Integer currentPage, Integer loginId) {
        OaInfoPagtionDto oaInfoPagtionDto = new OaInfoPagtionDto();
        oaInfoPagtionDto.setCurrentPage(currentPage);
        oaInfoPagtionDto.setPageSize(pageSize);
        if(loginId == null){
            oaInfoPagtionDto.setInfos(oaInfoMapper.selectAllInfoByKeyLimit(key, pageSize, (currentPage - 1) * pageSize));
        } else {
            oaInfoPagtionDto.setInfos(oaInfoMapper.selectInfoByKeyLimit(key, pageSize, (currentPage - 1) * pageSize, loginId));
        }
        oaInfoPagtionDto.setTotalPage((oaInfoMapper.selectInfoByKey(key) - 1) / pageSize + 1);
        return oaInfoPagtionDto;
    }

}
