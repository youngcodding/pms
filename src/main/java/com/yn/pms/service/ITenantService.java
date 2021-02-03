package com.yn.pms.service;

import com.yn.pms.entity.Tenant;

import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-8:45
 */
public interface ITenantService  {

    /**
     * 新增租户
     * @param tenant
     * @return
     * @throws Exception
     */
    public boolean saveTenant(Tenant tenant) throws Exception;

    /**
     * 修改租户信息
     * @param tenant
     * @return
     * @throws Exception
     */
    public boolean updateTenant(Tenant tenant) throws  Exception;

    /**
     * 根据租户id删除租户信息
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteTenant(Integer id) throws  Exception;

    /**
     * 根据主键查询
     * @param id
     * @return
     * @throws Exception
     */
    public Tenant findById(Integer id) throws Exception;

    /**
     * 根据关键字进行模糊分页查询
     * @param kw
     * @param cp
     * @param ls
     * @return
     * @throws Exception
     */
    public Map<String,Object> findBySplit(String kw,Integer cp,Integer ls) throws Exception;

}
