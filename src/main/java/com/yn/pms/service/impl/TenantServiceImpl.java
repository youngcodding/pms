package com.yn.pms.service.impl;

import com.yn.pms.dao.ITenantDAO;
import com.yn.pms.entity.Tenant;
import com.yn.pms.service.ITenantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-9:10
 */
@Service
public class TenantServiceImpl implements ITenantService {

    @Resource
    private ITenantDAO dao;
    /**
     * 新增租户
     * @param tenant
     * @return
     * @throws Exception
     */
    @Override
    public boolean saveTenant(Tenant tenant) throws Exception {
        return dao.daoCreate(tenant)>0;
    }

    /**
     * 修改租户信息
     * @param tenant
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateTenant(Tenant tenant) throws Exception {
        return dao.daoUpdate(tenant)>0;
    }

    /**
     * 删除租户
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteTenant(Integer id) throws Exception {
        return dao.daoRemoveById(id)>0;
    }

    /**
     * 租户查询
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Tenant findById(Integer id) throws Exception {
        return dao.daoFindById(id);
    }

    /**
     * 根据关键字进行模糊分页查询
     * @param kw 关键字
     * @param cp  当前页码
     * @param ls  每页数量
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> findBySplit(String kw, Integer cp, Integer ls) throws Exception {
        Map<String,Object> tenantMap = new HashMap<>();
        //租户信息集合
        tenantMap.put("tenantList",dao.daoFindSplit("%"+kw+"%",(cp-1)*ls,ls));

        //总记录数
        int count = dao.daoCount("%" + kw + "%");
        //总页数
        int pageSize = count/ls+(count%ls==0?0:1);
        tenantMap.put("count",count);
        tenantMap.put("pageSize",pageSize);
        tenantMap.put("kw",kw);
        tenantMap.put("ls",ls);
        tenantMap.put("cp",cp);
        return tenantMap;
    }
}
