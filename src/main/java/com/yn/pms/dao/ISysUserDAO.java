package com.yn.pms.dao;

import com.yn.pms.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/27-11:47
 */
@Mapper
public interface ISysUserDAO extends IDAO<Integer, SysUser>{

    /**
     * 实现登录操作 该方法是子接口特有的方法
     * @param name
     * @param pwd
     * @return
     * @throws Exception
     */
    public SysUser selectLogin(@Param("name") String name, @Param("pwd")  String pwd) throws Exception;

    /**
     * 查询昵称是否存在
     * @param nickname
     * @return
     * @throws Exception
     */
    public SysUser selectByNickName(@Param("nickname") String nickname,@Param("uid") Integer uid)throws Exception;
}
