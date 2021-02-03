package com.yn.pms.dao;

import com.yn.pms.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/2-10:35
 */
@Mapper
public interface IResidenceDAO {

    /**
     * 查询开发商信息
     * @param cid
     * @return
     * @throws Exception
     */
    public Developer selectDeveloperByCid(Integer cid) throws Exception;


    /**
     * 新增小区信息
     * @param community
     * @return
     * @throws Exception
     */
    public int insertCommunity(Community community) throws Exception;


    /**
     * 新增楼栋信息
     * @param build
     * @return
     * @throws Exception
     */
    public int insertBuild(Build build) throws Exception;


    /**
     * 新增楼层信息
     * @param floor
     * @return
     * @throws Exception
     */
    public int insertFloor(Floor floor) throws  Exception;

    /**
     * 新增房间信息
     * @param room
     * @return
     * @throws Exception
     */
    public int insertRoom(Room room) throws Exception;

    /**
     * 查询楼栋里的所有房间数
     * @param bid
     * @return
     * @throws Exception
     */
    public Integer selectRoomCount(Integer bid)throws Exception;

    /**
     * 查询楼栋里已出售 或者 出租的房间数量
     * @param bid
     * @param status
     * @return
     */
    public Integer selectRentedOrSoldNum(@Param("bid") Integer bid, @Param("status") Integer status);

}
