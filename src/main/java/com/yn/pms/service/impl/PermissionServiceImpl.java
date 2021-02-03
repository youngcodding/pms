package com.yn.pms.service.impl;

import com.yn.pms.dao.IPermissionDAO;
import com.yn.pms.entity.Permission;
import com.yn.pms.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/29-14:32
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    private IPermissionDAO permissionDAO;

    @Override
    public Permission findById(Integer uid) throws Exception {
        return permissionDAO.daoFindById(uid);
    }

    @Override
    public boolean updatePermission(Permission permission) throws Exception {
        return permissionDAO.daoUpdate(permission)>0;
    }
}
