package com.yn.pms.service;

import com.yn.pms.entity.Permission;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/29-14:30
 */
public interface IPermissionService {
    /**
     * 根据uid查询权限
     * @param uid
     * @return
     * @throws Exception
     */
    public Permission findById(Integer uid) throws  Exception;

    /**
     * 修改权限信息
     * @param permission
     * @return
     * @throws Exception
     */
    public boolean updatePermission(Permission permission) throws Exception;
}
