package com.yn.pms.service;

import com.yn.pms.entity.*;

import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-20:19
 */
public interface IContractService {

    /**
     * 查询所有小区
     * @return
     * @throws Exception
     */
    public List<Community> findCommunitits() throws Exception;

    /**
     * 查询该小区下的所有楼栋
     * @param cid
     * @return
     * @throws Exception
     */
    public List<Build> findBuilds(Integer cid) throws  Exception;

    /**
     * 查询该楼栋下的所有楼层
     * @param bid
     * @return
     * @throws Exception
     */
    public List<Floor> findFloors(Integer bid) throws  Exception;

    /**
     * 查询楼层下的所有房间
     * @param fid
     * @return
     * @throws Exception
     */
    public List<Room> findRooms(Integer fid) throws Exception;

    /**
     * 添加合约的方法
     * @param contract
     * @return
     * @throws Exception
     */
    public boolean addContract(Contract contract)  throws  Exception;
}
