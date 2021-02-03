package com.yn.pms.dao;

import com.yn.pms.entity.Properietor;
import com.yn.pms.entity.Room;
import com.yn.pms.entity.SellContract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-9:04
 */
@Mapper
public interface ISellContract extends IDAO<Integer, SellContract> {

    /**
     * 增加业主信息
     * @param properietor
     * @return
     * @throws Exception
     */
    public Integer insertProperietor(Properietor properietor) throws Exception;


    public Properietor findProperietor(@Param("pname")String pname,@Param("phone")String phone) throws Exception;
    /**
     *
     * @param cid
     * @param bid
     * @param fid
     * @param status
     * @param cp
     * @param ls
     * @return
     * @throws Exception
     */
    public List<Room> selectAllSoldRooms(@Param("cid")Integer cid,@Param("bid")Integer bid,@Param("fid")Integer fid,
                                         @Param("status") Integer status, @Param("cp") Integer cp, @Param("ls") Integer ls) throws Exception;

    Integer count(@Param("cid")Integer cid,@Param("bid")Integer bid,@Param("fid")Integer fid,
                  @Param("status") Integer status) throws Exception;

}
