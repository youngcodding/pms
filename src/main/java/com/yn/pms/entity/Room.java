package com.yn.pms.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-19:47
 */
public class Room implements Serializable {
    private Integer id;
    private Integer property;
    @JSONField(name = "name")
    private String roomName;
    private Integer roomNum;
    private String houseType;
    private Double roomArea;
    private Double useArea;
    private String toward;
    private String decoration;
    private Integer statusTenant;
    private Integer floor_id;
    private Integer developer_id;
    private Integer properietor_id;

    public Room() {
    }

    public Room(Integer id, Integer property, String roomName, Integer roomNum, String houseType, Double roomArea, Double useArea, String toward, String decoration, Integer statusTenant, Integer floor_id, Integer developer_id, Integer properietor_id) {
        this.id = id;
        this.property = property;
        this.roomName = roomName;
        this.roomNum = roomNum;
        this.houseType = houseType;
        this.roomArea = roomArea;
        this.useArea = useArea;
        this.toward = toward;
        this.decoration = decoration;
        this.statusTenant = statusTenant;
        this.floor_id = floor_id;
        this.developer_id = developer_id;
        this.properietor_id = properietor_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProperty() {
        return property;
    }

    public void setProperty(Integer property) {
        this.property = property;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Double getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(Double roomArea) {
        this.roomArea = roomArea;
    }

    public Double getUseArea() {
        return useArea;
    }

    public void setUseArea(Double useArea) {
        this.useArea = useArea;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public Integer getStatusTenant() {
        return statusTenant;
    }

    public void setStatusTenant(Integer statusTenant) {
        this.statusTenant = statusTenant;
    }

    public Integer getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(Integer floor_id) {
        this.floor_id = floor_id;
    }

    public Integer getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(Integer developer_id) {
        this.developer_id = developer_id;
    }

    public Integer getProperietor_id() {
        return properietor_id;
    }

    public void setProperietor_id(Integer properietor_id) {
        this.properietor_id = properietor_id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", property=" + property +
                ", roomName='" + roomName + '\'' +
                ", roomNum=" + roomNum +
                ", houseType='" + houseType + '\'' +
                ", roomArea=" + roomArea +
                ", useArea=" + useArea +
                ", toward='" + toward + '\'' +
                ", decoration='" + decoration + '\'' +
                ", statusTenant=" + statusTenant +
                ", floor_id=" + floor_id +
                ", developer_id=" + developer_id +
                ", properietor_id=" + properietor_id +
                '}';
    }
}
