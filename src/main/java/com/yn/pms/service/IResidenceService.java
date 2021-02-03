package com.yn.pms.service;

import com.yn.pms.entity.*;
import com.yn.pms.vo.Statistics;

import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/2-11:03
 */
public interface IResidenceService {

    /**
     * 根据小区查找开发商信息
     * @param cid
     * @return
     * @throws Exception
     */
    Developer findDeveloperByCid(Integer cid) throws Exception;

    /**
     * 增加小区信息
     * @param community
     * @return
     * @throws Exception
     */
    boolean addCommunity(Community community) throws Exception;

    /**
     * 添加楼栋信息
     * @param build
     * @return
     * @throws Exception
     */
    boolean addBuild(Build build) throws Exception;

    /**
     * 添加楼层信息
     * @param floor
     * @return
     * @throws Exception
     */
    boolean addFloor(Floor floor) throws Exception;

    /**
     * 添加房间信息
     * @param room
     * @return
     * @throws Exception
     */
    boolean addRoom(Room room) throws Exception;

    /**
     * 统计小区楼栋信息
     * @param cid
     * @return
     * @throws Exception
     */
    List<Statistics> selectStatistics(Integer cid) throws Exception;
}
