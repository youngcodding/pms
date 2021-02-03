package com.yn.pms.service;

import com.yn.pms.entity.Inspection;

import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-19:57
 */
public interface IIinspectionService {


    Inspection insertInspection(Inspection inspection) throws Exception;


    Map<String,Object> findInspectionByRid(Integer rid) throws  Exception;

    boolean removeById(Integer id) throws Exception;
}
