package com.yn.pms.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-19:40
 */
public class Community implements Serializable {
    private Integer id;
    @JSONField(name = "name")
    private String cCompanyName;
    private Integer communityNum;
    private String residentialName;
    private Double coverArea;
    private Double constructionArea;
    private Double greenArea;
    private Double roadArea;
    private Integer buildCount;
    private String principal;
    private String cAddr;
    private Integer developer_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcCompanyName() {
        return cCompanyName;
    }

    public void setcCompanyName(String cCompanyName) {
        this.cCompanyName = cCompanyName;
    }

    public Integer getCommunityNum() {
        return communityNum;
    }

    public void setCommunityNum(Integer communityNum) {
        this.communityNum = communityNum;
    }

    public String getResidentialName() {
        return residentialName;
    }

    public void setResidentialName(String residentialName) {
        this.residentialName = residentialName;
    }

    public Double getCoverArea() {
        return coverArea;
    }

    public void setCoverArea(Double coverArea) {
        this.coverArea = coverArea;
    }

    public Double getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(Double constructionArea) {
        this.constructionArea = constructionArea;
    }

    public Double getGreenArea() {
        return greenArea;
    }

    public void setGreenArea(Double greenArea) {
        this.greenArea = greenArea;
    }

    public Double getRoadArea() {
        return roadArea;
    }

    public void setRoadArea(Double roadArea) {
        this.roadArea = roadArea;
    }

    public Integer getBuildCount() {
        return buildCount;
    }

    public void setBuildCount(Integer buildCount) {
        this.buildCount = buildCount;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getcAddr() {
        return cAddr;
    }

    public void setcAddr(String cAddr) {
        this.cAddr = cAddr;
    }

    public Integer getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(Integer developer_id) {
        this.developer_id = developer_id;
    }

    public Community() {
    }

    public Community(Integer id, String cCompanyName, Integer communityNum, String residentialName, Double coverArea, Double constructionArea, Double greenArea, Double roadArea, Integer buildCount, String principal, String cAddr, Integer developer_id) {
        this.id = id;
        this.cCompanyName = cCompanyName;
        this.communityNum = communityNum;
        this.residentialName = residentialName;
        this.coverArea = coverArea;
        this.constructionArea = constructionArea;
        this.greenArea = greenArea;
        this.roadArea = roadArea;
        this.buildCount = buildCount;
        this.principal = principal;
        this.cAddr = cAddr;
        this.developer_id = developer_id;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", cCompanyName='" + cCompanyName + '\'' +
                ", communityNum=" + communityNum +
                ", residentialName='" + residentialName + '\'' +
                ", coverArea=" + coverArea +
                ", constructionArea=" + constructionArea +
                ", greenArea=" + greenArea +
                ", roadArea=" + roadArea +
                ", buildCount=" + buildCount +
                ", principal='" + principal + '\'' +
                ", cAddr='" + cAddr + '\'' +
                ", developer_id=" + developer_id +
                '}';
    }
}
