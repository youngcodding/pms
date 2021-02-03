package com.yn.pms.controller;

import com.yn.pms.entity.*;
import com.yn.pms.service.IContractService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-20:30
 */
@Controller
@RequestMapping("/contract/*")
@ResponseBody
public class ContractController extends BaseController {

    @Resource
    private IContractService contractService;

    @RequestMapping("community")
    public List<Community> listCommunity()throws Exception{
        return contractService.findCommunitits();
    }

    @RequestMapping("build")
    public List<Build> listBuild(Integer id) throws Exception{
        return contractService.findBuilds(id);
    }

    @RequestMapping("floor")
    public List<Floor> listFloor(Integer id)throws Exception{
        return contractService.findFloors(id);
    }

    @RequestMapping("room")
    public List<Room> listRoom(Integer id)throws Exception{
        return contractService.findRooms(id);
    }

    @RequestMapping("add")
    public boolean addContract(Contract contract)throws Exception{
        return contractService.addContract(contract);
    }


    @Override
    public String getDir() {
        return null;
    }
}
