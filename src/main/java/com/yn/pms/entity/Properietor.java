package com.yn.pms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-8:44
 */
public class Properietor implements Serializable {
    private Integer id;
    private String proprietorName;
    private Integer gender;
    private Date brithday;
    private String IDNum;
    private String phone;
    private Integer status;
    private String belongCompany;
    private String address;

    public Properietor() {
    }

    public Properietor(Integer id, String proprietorName, Integer gender, Date brithday, String IDNum, String phone, Integer status, String belongCompany, String address) {
        this.id = id;
        this.proprietorName = proprietorName;
        this.gender = gender;
        this.brithday = brithday;
        this.IDNum = IDNum;
        this.phone = phone;
        this.status = status;
        this.belongCompany = belongCompany;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProprietorName() {
        return proprietorName;
    }

    public void setProprietorName(String proprietorName) {
        this.proprietorName = proprietorName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBelongCompany() {
        return belongCompany;
    }

    public void setBelongCompany(String belongCompany) {
        this.belongCompany = belongCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Properietor{" +
                "id=" + id +
                ", proprietorName='" + proprietorName + '\'' +
                ", gender=" + gender +
                ", brithday=" + brithday +
                ", IDNum='" + IDNum + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", belongCompany='" + belongCompany + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
