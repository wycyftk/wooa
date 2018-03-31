package com.wo.ms.oa.services;

import com.wo.ms.oa.entity.OaUser;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;

public interface OaUserService {
    OaUser selectOaUser(Integer userId);

    Integer addOaUser(OaUser oaUser);

    Integer updateOaUser(OaUser oaUser);

    Integer deleteOaUser(Integer userId);
}
