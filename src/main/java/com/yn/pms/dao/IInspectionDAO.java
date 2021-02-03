package com.yn.pms.dao;

import com.yn.pms.entity.Inspection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-19:50
 */
@Mapper
public interface IInspectionDAO extends IDAO<Integer,Inspection> {

    public List<Inspection> selectInspectionList(Integer rid) throws Exception;

}
