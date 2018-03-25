package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "oa_role")
public class OaRole extends BaseEntity {
    @Column(length = 200)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
