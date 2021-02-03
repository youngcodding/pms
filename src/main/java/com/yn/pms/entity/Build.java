package com.yn.pms.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-19:43
 */
public class Build implements Serializable {
    private Integer id;
    private Integer buildNum;
    @JSONField(name = "name")
    private String buildName;
    private Integer floorCount;
    private Integer community_id;

    public Build() {
    }

    public Build(Integer id, Integer buildNum, String buildName, Integer floorCount, Integer community_id) {
        this.id = id;
        this.buildNum = buildNum;
        this.buildName = buildName;
        this.floorCount = floorCount;
        this.community_id = community_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(Integer buildNum) {
        this.buildNum = buildNum;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }

    public Integer getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(Integer community_id) {
        this.community_id = community_id;
    }

    @Override
    public String toString() {
        return "Build{" +
                "id=" + id +
                ", buildNum=" + buildNum +
                ", buildName='" + buildName + '\'' +
                ", floorCount=" + floorCount +
                ", community_id=" + community_id +
                '}';
    }
}
