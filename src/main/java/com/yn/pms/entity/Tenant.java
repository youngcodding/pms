package com.yn.pms.entity;

import java.io.Serializable;

/**
 * @author yn
 * @class pms
 * @describe 租户实体类
 * @date 2021/2/1-8:29
 */
public class Tenant implements Serializable {
    private Integer id;
    private String companyname;
    private String phone;
    private String managername;
    private String identity;
    private String identitypositive;
    private String identitynegative;
    private String licensepath;

    public Tenant() {
    }

    public Tenant(Integer id, String companyname, String phone, String managername, String identity, String identitypositive, String identitynegative, String licensepath) {
        this.id = id;
        this.companyname = companyname;
        this.phone = phone;
        this.managername = managername;
        this.identity = identity;
        this.identitypositive = identitypositive;
        this.identitynegative = identitynegative;
        this.licensepath = licensepath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIdentitypositive() {
        return identitypositive;
    }

    public void setIdentitypositive(String identitypositive) {
        this.identitypositive = identitypositive;
    }

    public String getIdentitynegative() {
        return identitynegative;
    }

    public void setIdentitynegative(String identitynegative) {
        this.identitynegative = identitynegative;
    }

    public String getLicensepath() {
        return licensepath;
    }

    public void setLicensepath(String licensepath) {
        this.licensepath = licensepath;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                ", phone='" + phone + '\'' +
                ", managername='" + managername + '\'' +
                ", identity='" + identity + '\'' +
                ", identitypositive='" + identitypositive + '\'' +
                ", identitynegative='" + identitynegative + '\'' +
                ", licensepath='" + licensepath + '\'' +
                '}';
    }
}
