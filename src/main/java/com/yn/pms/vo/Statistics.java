package com.yn.pms.vo;

import java.io.Serializable;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/2-16:13
 */
public class Statistics implements Serializable {
    private Integer id;
    private String buildName;
    private Integer buildRoomCount;
    private Integer rented;
    private Integer sold;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Integer getBuildRoomCount() {
        return buildRoomCount;
    }

    public void setBuildRoomCount(Integer buildRoomCount) {
        this.buildRoomCount = buildRoomCount;
    }

    public Integer getRented() {
        return rented;
    }

    public void setRented(Integer rented) {
        this.rented = rented;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", buildName='" + buildName + '\'' +
                ", buildRoomCount=" + buildRoomCount +
                ", rented=" + rented +
                ", sold=" + sold +
                '}';
    }
}
