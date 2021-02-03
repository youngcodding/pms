package com.yn.pms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-19:52
 */
public class Contract implements Serializable {
    private Integer id;
    private Integer tenant_id;
    private Integer pcharge_id;
    private Integer purpose_id;
    private Date signtime;
    private Date starttime;
    private Date endtime;
    private Double monthfee;
    private Double deposit;
    private String remarks;
    private Integer room_id;

    public Contract() {
    }

    public Contract(Integer id, Integer tenant_id, Integer pcharge_id, Integer purpose_id, Date signtime, Date starttime, Date endtime, Double monthfee, Double deposit, String remarks, Integer room_id) {
        this.id = id;
        this.tenant_id = tenant_id;
        this.pcharge_id = pcharge_id;
        this.purpose_id = purpose_id;
        this.signtime = signtime;
        this.starttime = starttime;
        this.endtime = endtime;
        this.monthfee = monthfee;
        this.deposit = deposit;
        this.remarks = remarks;
        this.room_id = room_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Integer tenant_id) {
        this.tenant_id = tenant_id;
    }

    public Integer getPcharge_id() {
        return pcharge_id;
    }

    public void setPcharge_id(Integer pcharge_id) {
        this.pcharge_id = pcharge_id;
    }

    public Integer getPurpose_id() {
        return purpose_id;
    }

    public void setPurpose_id(Integer purpose_id) {
        this.purpose_id = purpose_id;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Double getMonthfee() {
        return monthfee;
    }

    public void setMonthfee(Double monthfee) {
        this.monthfee = monthfee;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", tenant_id=" + tenant_id +
                ", pcharge_id=" + pcharge_id +
                ", purpose_id=" + purpose_id +
                ", signtime=" + signtime +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", monthfee=" + monthfee +
                ", deposit=" + deposit +
                ", remarks='" + remarks + '\'' +
                ", room_id=" + room_id +
                '}';
    }
}
