package com.yn.pms.controller;

import com.yn.pms.entity.Inspection;
import com.yn.pms.service.IIinspectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-20:01
 */
@RestController
@RequestMapping("/inspection/*")
public class InspectionController extends BaseController {

    @Resource
    private IIinspectionService service;


    @RequestMapping("add")
    public Inspection addInspection(Inspection inspection)throws Exception{
        return service.insertInspection(inspection);
    }
    @RequestMapping("remove")
    public boolean removeInspection(Integer id) throws Exception{
        return service.removeById(id);
    }
    @RequestMapping("list")
    public List<Inspection> list(Integer rid) throws Exception{
        List<Inspection> list = (List<Inspection>)service.findInspectionByRid(rid).get("list");
        return  list;
    }

    @Override
    public String getDir() {
        return null;
    }
}
