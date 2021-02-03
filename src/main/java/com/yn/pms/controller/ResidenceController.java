package com.yn.pms.controller;

import com.yn.pms.entity.*;
import com.yn.pms.service.IResidenceService;
import com.yn.pms.vo.Statistics;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/2-11:32
 */
@RestController
@RequestMapping("/residence/*")
public class ResidenceController {

    @Resource
    private IResidenceService residenceService;

    @RequestMapping("getDeveloper")
    public Developer getDeveloperById(Integer id) throws Exception{
        return residenceService.findDeveloperByCid(id);
    }

    @RequestMapping("addCommunity")
    public boolean addCommunity(Community community) throws Exception{
        return residenceService.addCommunity(community);
    }
    @RequestMapping("addBuild")
    public boolean addBuild(Build build) throws Exception{
        return residenceService.addBuild(build);
    }
    @RequestMapping("addFloor")
    public boolean addFloor(Floor floor) throws Exception{
        return  residenceService.addFloor(floor);
    }
    @RequestMapping("addRoom")
    public boolean addRoom(Room room) throws Exception{
        return residenceService.addRoom(room);
    }

    @RequestMapping("statistics")
    public List<Statistics> getStatistics(Integer cid)throws Exception{
        return residenceService.selectStatistics(cid);
    }
}
