package com.yn.pms.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-19:45
 */
public class Floor implements Serializable {
    private Integer id;
    private Integer floorNum;
    @JSONField(name = "name")
    private String floorName;
    private Double floorArea;
    private Double publicArea;
    private Integer roomCount;
    private Integer build_id;

    public Floor() {
    }

    public Floor(Integer id, Integer floorNum, String floorName, Double floorArea, Double publicArea, Integer roomCount, Integer build_id) {
        this.id = id;
        this.floorNum = floorNum;
        this.floorName = floorName;
        this.floorArea = floorArea;
        this.publicArea = publicArea;
        this.roomCount = roomCount;
        this.build_id = build_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public Double getPublicArea() {
        return publicArea;
    }

    public void setPublicArea(Double publicArea) {
        this.publicArea = publicArea;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Integer getBuild_id() {
        return build_id;
    }

    public void setBuild_id(Integer build_id) {
        this.build_id = build_id;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", floorNum=" + floorNum +
                ", floorName='" + floorName + '\'' +
                ", floorArea=" + floorArea +
                ", publicArea=" + publicArea +
                ", roomCount=" + roomCount +
                ", build_id=" + build_id +
                '}';
    }
}
