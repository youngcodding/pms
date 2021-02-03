package com.yn.pms.service;

import com.yn.pms.entity.SellContract;

import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-9:46
 */
public interface ISellContractService {

    boolean createSellContract(SellContract sellContract) throws Exception;

    Map<String,Object> findAllRooms(Integer cid,Integer bid,Integer fid,Integer status,Integer cp,Integer ls) throws Exception;

    SellContract findByRid(Integer rid) throws Exception;





}
