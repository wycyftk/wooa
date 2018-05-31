package com.wo.ms.oa.services.impl;

import com.wo.ms.oa.dao.OaMeetingMapper;
import com.wo.ms.oa.dto.OaMeetingPagtion;
import com.wo.ms.oa.entity.OaMeeting;
import com.wo.ms.oa.services.OaMeetingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OaMeetingServiceImpl implements OaMeetingService {
    @Resource
    private OaMeetingMapper oaMeetingMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return oaMeetingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OaMeeting record) {
        return oaMeetingMapper.insert(record);
    }

    @Override
    public OaMeeting selectByPrimaryKey(Integer id) {
        return oaMeetingMapper.selectByPrimaryKey(id);
    }

    @Override
    public OaMeetingPagtion selectMyMeetingLimit(String key, Integer pageSize, Integer currentPage, Integer loginId) {
        Integer totalPage = oaMeetingMapper.selectCountMyMeeting(key, loginId);
        totalPage = totalPage == null ? 0 : totalPage;
        OaMeetingPagtion oaMeetingPagtion = new OaMeetingPagtion();
        oaMeetingPagtion.setCurrentPage(currentPage);
        oaMeetingPagtion.setPageSize(pageSize);
        oaMeetingPagtion.setOaMeetingList(oaMeetingMapper.selectMyMeeting(key, pageSize, (currentPage - 1) * pageSize, loginId));
        oaMeetingPagtion.setTotalPage((totalPage - 1) / pageSize + 1);
        return oaMeetingPagtion;
    }

    @Override
    public int updateByPrimaryKeySelective(OaMeeting record) {
        return oaMeetingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public  List<Map<Integer, Integer>> selectDayAndMeetingNum() {
        return oaMeetingMapper.selectDayAndMeetingNum();
    }
}
