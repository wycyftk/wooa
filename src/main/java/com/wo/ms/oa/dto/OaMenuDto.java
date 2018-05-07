package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.OaMenu;

public class OaMenuDto extends OaMenu {
    private Integer chooseMenuId;

    /**
     * 与被选中节点的关系
     * 1.同级之前 2.同级之后 3.子节点末端
     */
    private Integer relation;

    public Integer getChooseMenuId() {
        return chooseMenuId;
    }

    public void setChooseMenuId(Integer chooseMenuId) {
        this.chooseMenuId = chooseMenuId;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }
}
