package com.wo.ms.oa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 菜单访问权限
 */
@Entity(name = "menu_access")
public class MenuAccess implements Serializable {
    @Id
    private Integer userId;

    /**
     * 角色id
     */
    @Id
    private Integer roleId;

    /**
     * 组织Id
     */
    @Id
    private Integer orgId;

    /**
     * 菜单Id
     */
    @Id
    private Integer menuId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
