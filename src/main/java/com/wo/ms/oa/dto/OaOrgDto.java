package com.wo.ms.oa.dto;

import com.wo.ms.oa.entity.OaOrg;

public class OaOrgDto extends OaOrg{
    private Integer chooseOrgId;

    /**
     * 与被选中节点的关系
     * 1.同级之前 2.同级之后 3.子节点末端
     */
    private Integer relation;

    public Integer getChooseOrgId() {
        return chooseOrgId;
    }

    public void setChooseOrgId(Integer chooseOrgId) {
        this.chooseOrgId = chooseOrgId;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }
}
