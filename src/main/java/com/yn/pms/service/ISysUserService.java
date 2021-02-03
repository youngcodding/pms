package com.yn.pms.service;

import com.yn.pms.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/27-11:54
 */
public interface ISysUserService {
    /**
     * 验证登录方法
     * @param name
     * @param pwd
     * @return
     * @throws Exception
     */
    public SysUser findLogin(String name ,String pwd) throws  Exception;

    /**
     * 新增用户
     * @param user
     * @return
     * @throws Exception
     */
    public boolean createSysUser(SysUser user)throws Exception;

    /**
     * 检验昵称是否被占用
     * @param nickName
     * @return
     * @throws Exception
     */
    public boolean checkNickName(String nickName,Integer uid) throws Exception;


    /**
     * 根据关键字进行模糊分页查询
     * @param kw
     * @param cp
     * @param ls
     * @return
     * @throws Exception
     */
    public Map<String,Object> findAllSplit(String kw,Integer cp,Integer ls) throws Exception;

    /**
     * 根据用户编号删除用户
     * @param uid
     * @return
     * @throws Exception
     */
    public boolean deleteUser(Integer uid) throws Exception;

    /**
     * 修改用户数据
     * @param user
     * @return
     * @throws Exception
     */
    public boolean updateUser(SysUser user) throws  Exception;

    /**
     * 根据编号查询
     * @param uid
     * @return
     * @throws Exception
     */
    public SysUser findById(Integer uid) throws  Exception;

}
