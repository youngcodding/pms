package com.yn.pms.service.impl;

import com.yn.pms.dao.IInspectionDAO;
import com.yn.pms.entity.Inspection;
import com.yn.pms.service.IIinspectionService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-19:59
 */
@Service
public class IinspectionServiceImpl implements IIinspectionService {

    @Resource
    private IInspectionDAO iInspectionDAO;

    @Override
    public Inspection insertInspection(Inspection inspection) throws Exception {
        iInspectionDAO.daoCreate(inspection);
        return inspection;
    }

    @Override
    public Map<String, Object> findInspectionByRid(Integer rid) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("list",iInspectionDAO.selectInspectionList(rid));
        return map;
    }

    @Override
    public boolean removeById(Integer id) throws Exception {
        return iInspectionDAO.daoRemoveById(id)>0;
    }
}
