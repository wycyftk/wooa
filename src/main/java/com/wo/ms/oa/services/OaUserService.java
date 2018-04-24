package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaUser;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;

import java.util.List;

public interface OaUserService {
    OaUser selectOaUser(Integer userId);

    List<OaUser> selectOaUserByKey(String key);

    Integer checkUser(String username, String password);

    Integer addOaUser(OaUser oaUser);

    Integer updateOaUser(OaUser oaUser);

    Integer deleteOaUser(Integer userId);
}
