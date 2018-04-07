package com.wo.ms.oa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户
 */
@Entity(name = "oa_user")
public class OaUser extends BaseEntity{
    /**
     * 姓名
     */
    @Column(length = 20)
    private String name;

    /**
     * 用户名
     */
    @Column(length = 20)
    private String username;

    /**
     * 密码
     */
    @Column(length = 200)
    private String password;

    /**
     * 性别,0是女，1是男
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 手机号

     */
    @Column(length = 20)
    private String mobile;

    /**
     * 邮箱
     */
    @Column(length = 50)
    private String email;

    /**
     * 删除标记，0未删除，1已删除
     */
    private Integer del_flg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDel_flg() {
        return del_flg;
    }

    public void setDel_flg(Integer del_flg) {
        this.del_flg = del_flg;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
