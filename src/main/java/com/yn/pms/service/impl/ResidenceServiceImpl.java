package com.yn.pms.service.impl;

import com.yn.pms.dao.IContractDAO;
import com.yn.pms.dao.IResidenceDAO;
import com.yn.pms.entity.*;
import com.yn.pms.service.IResidenceService;
import com.yn.pms.vo.Statistics;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/2-11:10
 */
@Service
public class ResidenceServiceImpl implements IResidenceService {

    @Resource
    private IResidenceDAO residenceDAO;

    @Resource
    private IContractDAO contractDAO;
    @Override
    public Developer findDeveloperByCid(Integer cid) throws Exception {
        return residenceDAO.selectDeveloperByCid(cid);
    }

    @Override
    public boolean addCommunity(Community community) throws Exception {
        return residenceDAO.insertCommunity(community)>0;
    }

    @Override
    public boolean addBuild(Build build) throws Exception {
        return residenceDAO.insertBuild(build)>0;
    }

    @Override
    public boolean addFloor(Floor floor) throws Exception {
        return residenceDAO.insertFloor(floor)>0;
    }

    @Override
    public boolean addRoom(Room room) throws Exception {
        return residenceDAO.insertRoom(room)>0;
    }

    /**
     * 统计小区楼栋信息
     * @param cid
     * @return
     * @throws Exception
     */
    @Override
    public List<Statistics> selectStatistics(Integer cid) throws Exception {
        List<Statistics> list = new ArrayList<>();

        List<Build> builds = contractDAO.selectBuilds(cid);
        for (Build build : builds) {
            Statistics statistics = new Statistics();
            statistics.setId(build.getId());
            statistics.setBuildName(build.getBuildName());
            statistics.setBuildRoomCount(residenceDAO.selectRoomCount(build.getId()));
            statistics.setRented(residenceDAO.selectRentedOrSoldNum(build.getId(),1));
            statistics.setSold(residenceDAO.selectRentedOrSoldNum(build.getId(),3));
            list.add(statistics);
        }
        return list;
    }
}
