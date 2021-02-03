package com.yn.pms.dao;

import com.yn.pms.entity.Tenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-8:31
 */
@Mapper
public interface ITenantDAO extends IDAO<Integer, Tenant> {
}
