package com.yn.pms.service.impl;

import com.yn.pms.dao.IPermissionDAO;
import com.yn.pms.dao.ISysUserDAO;
import com.yn.pms.entity.Permission;
import com.yn.pms.entity.SysUser;
import com.yn.pms.service.ISysUserService;
import org.omg.CORBA.UserException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/27-11:55
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private ISysUserDAO dao;

    @Resource
    private IPermissionDAO permissionDAO;

    /**
     * 验证登录方法
     * @param name
     * @param pwd
     * @return
     * @throws Exception
     */
    @Override
    public SysUser findLogin(String name, String pwd) throws Exception {
        SysUser user = dao.selectLogin(name, pwd);
        if (user!=null){
            Permission permission = permissionDAO.daoFindById(user.getUid());
            user.setPermission(permission);
        }
        return user;
    }

    /**
     * 新增用户
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public boolean createSysUser(SysUser user) throws Exception {
        //设置删除状态默认为1
        user.setDelstatus(1);
        boolean flag = dao.daoCreate(user) > 0;
        if (flag) {
            //创建用户成功就赋予默认的权限状态
            flag = permissionDAO.daoCreate(new Permission(user.getUid()))>0;
        }
        return flag;
    }

    /**
     * 检验昵称是否被占用
     * @param nickName
     * @return true:昵称可以使用  false 昵称被占用
     * @throws Exception
     */
    @Override
    public boolean checkNickName(String nickName,Integer uid) throws Exception {
        return dao.selectByNickName(nickName,uid)==null;
    }

    /**
     * 根据关键字进行模糊分页查询
     * @param kw
     * @param cp
     * @param ls
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> findAllSplit(String kw, Integer cp, Integer ls) throws Exception {
        Map<String,Object> map = new HashMap<>();
        //保存查询的数据集合
        map.put("userList",dao.daoFindSplit("%"+kw+"%",(cp-1)*ls,ls));
        //总记录数
        int count = dao.daoCount("%"+kw+"%");
        //总页码
        int pageSize = count/ls+(count%ls==0?0:1);
        map.put("count",count);
        map.put("pageSize",pageSize);
        map.put("cp",cp);
        map.put("ls",ls);
        map.put("kw",kw);
        System.out.println(map);
        return map;
    }

    /**
     * 根据用户编号删除用户
     * @param uid
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteUser(Integer uid) throws Exception {
        return dao.daoRemoveById(uid)>0;
    }

    /**
     * 修改用户数据
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateUser(SysUser user) throws Exception {
        return dao.daoUpdate(user)>0;
    }

    /**
     * 根据编号查询
     * @param uid
     * @return
     * @throws Exception
     */
    @Override
    public SysUser findById(Integer uid) throws Exception {
        return dao.daoFindById(uid);
    }


}
