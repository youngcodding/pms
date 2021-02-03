package com.yn.pms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/27-11:42
 */
public class SysUser implements Serializable {
    private Integer uid;
    private String name;
    private String nickname;
    private Integer delstatus; //删除状态 1 激活 0 删除,默认 1
    private String pwd;
    private String phone;
    private String email;
    private String qq;
    private Date regtime;
    private String img;//头像地址
    private Permission permission;//权限信息

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getDelstatus() {
        return delstatus;
    }

    public void setDelstatus(Integer delstatus) {
        this.delstatus = delstatus;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", delstatus=" + delstatus +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", regtime=" + regtime +
                ", img='" + img + '\'' +
                ", permission=" + permission +
                '}';
    }
}
