package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "oa_menu")
public class OaMenu extends BaseEntity{
    private String menuName;

    @Column(length = 50)
    private String descrition;

    @Column(length = 500)
    private String menuUrl;

    @Column(length = 20)
    private Integer leftNode;

    @Column(length = 20)
    private Integer rightNode;

    private Integer menuLevel;

    private Integer delFlg;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Integer leftNode) {
        this.leftNode = leftNode;
    }

    public Integer getRightNode() {
        return rightNode;
    }

    public void setRightNode(Integer rightNode) {
        this.rightNode = rightNode;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }
}