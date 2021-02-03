package com.yn.pms.entity;

import java.io.Serializable;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/2-10:35
 */
public class Developer implements Serializable {

    private Integer id;
    private String developerName;
    private String dCompanyName;
    private String lawPerson;
    private String linkman;
    private String phone;
    private String dAddr;
    private String remark;

    public Developer() {
    }

    public Developer(Integer id, String developerName, String dCompanyName, String lawPerson, String linkman, String phone, String dAddr, String remark) {
        this.id = id;
        this.developerName = developerName;
        this.dCompanyName = dCompanyName;
        this.lawPerson = lawPerson;
        this.linkman = linkman;
        this.phone = phone;
        this.dAddr = dAddr;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getdCompanyName() {
        return dCompanyName;
    }

    public void setdCompanyName(String dCompanyName) {
        this.dCompanyName = dCompanyName;
    }

    public String getLawPerson() {
        return lawPerson;
    }

    public void setLawPerson(String lawPerson) {
        this.lawPerson = lawPerson;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getdAddr() {
        return dAddr;
    }

    public void setdAddr(String dAddr) {
        this.dAddr = dAddr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", developerName='" + developerName + '\'' +
                ", dCompanyName='" + dCompanyName + '\'' +
                ", lawPerson='" + lawPerson + '\'' +
                ", linkman='" + linkman + '\'' +
                ", phone='" + phone + '\'' +
                ", dAddr='" + dAddr + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
