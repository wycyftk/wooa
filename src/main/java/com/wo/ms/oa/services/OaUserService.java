package com.wo.ms.oa.services;

import com.wo.ms.oa.dto.OaUserPagtionDto;
import com.wo.ms.oa.entity.OaUser;
import com.wo.ms.oa.entity.UserOrg;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;

import java.util.List;

public interface OaUserService {
    OaUser selectOaUser(Integer userId);

    List<OaUser> selectOaUserByKey(String key);

    OaUserPagtionDto selectOaUserPagtion(String key, Integer pageSize, Integer currentPage);

    Integer checkUser(String username, String password);

    Integer addOaUser(OaUser oaUser);

    Integer updateOaUser(OaUser oaUser);

    Integer deleteOaUser(Integer userId);

    Integer selectOrgIdByUserId(Integer userId);
}
