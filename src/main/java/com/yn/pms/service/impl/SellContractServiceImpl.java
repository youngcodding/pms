package com.yn.pms.service.impl;

import com.yn.pms.dao.IContractDAO;
import com.yn.pms.dao.ISellContract;
import com.yn.pms.entity.Properietor;
import com.yn.pms.entity.SellContract;
import com.yn.pms.service.ISellContractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-9:53
 */
@Service
public class SellContractServiceImpl implements ISellContractService {


    @Resource
    private ISellContract iSellContract;

    @Resource
    private IContractDAO contractDAO;

    @Override
    @Transactional
    public boolean createSellContract(SellContract sellContract) throws Exception {
        boolean flag;
        Properietor properietor = new Properietor();
        properietor.setProprietorName(sellContract.getProperietor_name());
        properietor.setAddress(sellContract.getAddress());
        properietor.setPhone(sellContract.getPhone());
        properietor.setGender(sellContract.getGender());
        properietor.setIDNum(sellContract.getIdentitycard_num());
        properietor.setStatus(1);
        flag=iSellContract.insertProperietor(properietor)>0;
        //生成合同编号
        sellContract.setSellcontract_id(new SimpleDateFormat("yyyyMMdd").format(sellContract.getSigntime())+ UUID.randomUUID().toString().replace("-",""));
        flag=iSellContract.daoCreate(sellContract)>0;
        flag=contractDAO.updateRoomStatus(sellContract.getRoom_id(),3)>0;
        return flag;
    }


    @Override
    public Map<String, Object> findAllRooms(Integer cid, Integer bid, Integer fid, Integer status, Integer cp, Integer ls) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("roomList",iSellContract.selectAllSoldRooms(cid,bid,fid,status,(cp-1)*ls,ls));
        Integer count = iSellContract.count(cid,bid,fid,status);
        int pageSize = count/ls + (count%ls==0?0:1);
        map.put("count",count);
        map.put("pageSize",pageSize);
        map.put("cp",cp);
        map.put("ls",ls);
        return map;
    }

    @Override
    public SellContract findByRid(Integer rid) throws Exception {
        SellContract sellContract = iSellContract.daoFindById(rid);
        Properietor properietor = iSellContract.findProperietor(sellContract.getProperietor_name(), sellContract.getPhone());
        sellContract.setGender(properietor.getGender());
        sellContract.setIdentitycard_num(properietor.getIDNum());
        sellContract.setAddress(properietor.getAddress());
        return sellContract;
    }
}
