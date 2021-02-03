package com.yn.pms.dao;

import com.yn.pms.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-19:55
 */
@Mapper
public interface IContractDAO extends IDAO<Integer, Contract> {

    /**
     * 查询所有小区信息
     * @return
     * @throws Exception
     */
    public List<Community> selectCommunities() throws  Exception;

    /**
     * 查询本小区所有的楼栋
     * @param cid
     * @return
     * @throws Exception
     */
    public List<Build> selectBuilds(Integer cid) throws Exception;

    /**
     * 查询该楼栋下的所有楼层
     * @param bid
     * @return
     * @throws Exception
     */
    public List<Floor> selectFloors(Integer bid) throws  Exception;

    /**
     * 查询该层的所有房间
     * @param fid
     * @return
     * @throws Exception
     */
    public List<Room> selectRooms(Integer fid) throws  Exception;

    /**
     * 修改房间的出租状态
     * @param rid
     * @param status
     * @return
     * @throws Exception
     */
    public int updateRoomStatus(@Param("rid") Integer rid, @Param("status") Integer status) throws  Exception;
}
