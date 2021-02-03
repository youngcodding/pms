package com.yn.pms.controller;

import com.yn.pms.entity.Permission;
import com.yn.pms.entity.SysUser;
import com.yn.pms.service.IPermissionService;
import com.yn.pms.service.ISysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/29-14:34
 */
@Controller
@RequestMapping("/limits/")
public class PermissionController extends BaseController {

    @Resource
    private IPermissionService permissionService;


    @RequestMapping("getById")
    public String getById(Integer uid,String uname, Model model) throws Exception {
        Permission permission = permissionService.findById(uid);
        model.addAttribute("limits",permission);
        model.addAttribute("uname",uname);
        model.addAttribute("uid",uid);
        return "limit/add_limitse";
    }
    @RequestMapping("update")
    @ResponseBody
    public boolean update(Permission permission) throws Exception {
        return permissionService.updatePermission(permission);
    }

    @Override
    public String getDir() {
        return null;
    }
}
