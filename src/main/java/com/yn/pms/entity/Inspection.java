package com.yn.pms.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-19:47
 */
public class Inspection implements Serializable {
    private Integer id;
    private String itemName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date acceptDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date confirmDate;
    private String accept;
    private String personnel;
    private String ownerOpinion;
    private String personnelOpinion;
    private String remake;
    private Integer room_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getOwnerOpinion() {
        return ownerOpinion;
    }

    public void setOwnerOpinion(String ownerOpinion) {
        this.ownerOpinion = ownerOpinion;
    }

    public String getPersonnelOpinion() {
        return personnelOpinion;
    }

    public void setPersonnelOpinion(String personnelOpinion) {
        this.personnelOpinion = personnelOpinion;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }
}
