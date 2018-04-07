package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 角色
 */
@Entity(name = "oa_role")
public class OaRole extends BaseEntity {
    /**
     * 角色名称
     */
    @Column(length = 200, nullable = false)
    private String roleName;

    /**
     * 角色编码
     */
    @Column(length = 200, nullable = false)
    private String roleCode;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
