package com.yn.pms.entity;

import java.io.Serializable;

/**
 * @author yn
 * @class pms
 * @describe  权限分配表
 * @date 2021/1/29-9:48
 */
public class Permission implements Serializable {
    /*0：默认没有权限  1：有权限*/
    private Integer uid;  //用户id
    private Integer addUserLimit; //添加用户的权限
    private Integer updateUserLimit;  //操作用户的权限
    private Integer addowenerLimit;//添加业主的权限
    private Integer updateOwnerLimit;//操作业主的权限

    public Permission() {
    }

    public Permission(Integer uid) {
        //这里除了用户id 其余都是默认赋值
        this.uid = uid;
        this.addUserLimit = 0;
        this.updateUserLimit = 0;
        this.addowenerLimit = 0;
        this.updateOwnerLimit = 0;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAddUserLimit() {
        return addUserLimit==null?0:addUserLimit;
    }

    public void setAddUserLimit(Integer addUserLimit) {
        this.addUserLimit = addUserLimit;
    }

    public Integer getUpdateUserLimit() {
        return updateUserLimit==null?0:updateUserLimit;
    }

    public void setUpdateUserLimit(Integer updateUserLimit) {
        this.updateUserLimit = updateUserLimit;
    }

    public Integer getAddowenerLimit() {
        return addowenerLimit==null?0:addowenerLimit;
    }

    public void setAddowenerLimit(Integer addowenerLimit) {
        this.addowenerLimit = addowenerLimit;
    }

    public Integer getUpdateOwnerLimit() {
        return updateOwnerLimit==null?0:updateOwnerLimit;
    }

    public void setUpdateOwnerLimit(Integer updateOwnerLimit) {
        this.updateOwnerLimit = updateOwnerLimit;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "uid=" + uid +
                ", addUserLimit=" + addUserLimit +
                ", updateUserLimit=" + updateUserLimit +
                ", addowenerLimit=" + addowenerLimit +
                ", updateOwnerLimit=" + updateOwnerLimit +
                '}';
    }
}
