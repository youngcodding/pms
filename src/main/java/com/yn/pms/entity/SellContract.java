package com.yn.pms.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-8:57
 */
public class SellContract implements Serializable {

    private Integer id;
    private String residence_info;
    private Integer room_id;
    private String sellcontract_id;
    private Date signtime;
    private String properietor_name;
    private String phone;
    private Double contract_value;
    private String payment_method;
    private String identitypositive;

    private Integer gender;
    private  String address;
    private String identitycard_num;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentitycard_num() {
        return identitycard_num;
    }

    public void setIdentitycard_num(String identitycard_num) {
        this.identitycard_num = identitycard_num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResidence_info() {
        return residence_info;
    }

    public void setResidence_info(String residence_info) {
        this.residence_info = residence_info;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getSellcontract_id() {
        return sellcontract_id;
    }

    public void setSellcontract_id(String sellcontract_id) {
        this.sellcontract_id = sellcontract_id;
    }

    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public String getProperietor_name() {
        return properietor_name;
    }

    public void setProperietor_name(String properietor_name) {
        this.properietor_name = properietor_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getContract_value() {
        return contract_value;
    }

    public void setContract_value(Double contract_value) {
        this.contract_value = contract_value;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getIdentitypositive() {
        return identitypositive;
    }

    public void setIdentitypositive(String identitypositive) {
        this.identitypositive = identitypositive;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }



}
