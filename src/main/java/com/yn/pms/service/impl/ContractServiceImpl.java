package com.yn.pms.service.impl;

import com.yn.pms.dao.IContractDAO;
import com.yn.pms.entity.*;
import com.yn.pms.service.IContractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-20:24
 */
@Service
public class ContractServiceImpl implements IContractService {

    @Resource
    private IContractDAO contractDAO;

    /**
     * 查询所有小区
     * @return
     * @throws Exception
     */
    @Override
    public List<Community> findCommunitits() throws Exception {
        return contractDAO.selectCommunities();
    }

    /**
     * 查询小区里的所有楼栋
     * @param cid
     * @return
     * @throws Exception
     */
    @Override
    public List<Build> findBuilds(Integer cid) throws Exception {
        return contractDAO.selectBuilds(cid);
    }

    /**
     * 查询该楼栋下的所有楼层
     * @param bid
     * @return
     * @throws Exception
     */
    @Override
    public List<Floor> findFloors(Integer bid) throws Exception {
        return contractDAO.selectFloors(bid);
    }

    /**
     * 查询该楼层下的所有房间
     * @param fid
     * @return
     * @throws Exception
     */
    @Override
    public List<Room> findRooms(Integer fid) throws Exception {
        return contractDAO.selectRooms(fid);
    }

    /**
     * 增加合同
     * @param contract
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public boolean addContract(Contract contract) throws Exception {
        boolean flag =contractDAO.daoCreate(contract)>0;
        if (flag){
            flag=contractDAO.updateRoomStatus(contract.getRoom_id(),1)>0;
        }
        return flag;
    }
}
