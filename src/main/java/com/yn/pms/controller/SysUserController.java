package com.yn.pms.controller;

import com.yn.pms.entity.SysUser;
import com.yn.pms.service.ISysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/27-13:55
 */
@Controller
@RequestMapping("/sysuser/*")
public class SysUserController extends BaseController {

    @Resource
    private ISysUserService sysUserService;
    @RequestMapping("login")
    public String login(String uname , String pwd, String rand ,HttpServletRequest req) throws  Exception{
/*
        if (rand==null||rand.equals("")){
            //验证码为空
            req.setAttribute("msg","请输入验证码！");
            return "login";
        }
        if (!rand.equalsIgnoreCase((String)req.getSession().getAttribute("rand"))){
            //验证码错误
            req.setAttribute("msg","验证码错误！");
            return "login";
        }*/
        SysUser user = sysUserService.findLogin(uname, pwd);
        if (user!=null){
            req.getSession().setAttribute("user",user);
            //客户端重定向 相当于在发起了一次请求
            return "redirect:/home.html";
        }else {
            req.setAttribute("msg","用户名密码错误!");
            //服务端重定向
            return "login";
        }
    }


    @RequestMapping("add")
    @ResponseBody
    public boolean addUser(SysUser user,HttpServletRequest request) throws Exception {
        if (!super.isAuth("addUserLimit",request)){
            return  false;
        }
        return sysUserService.createSysUser(user);
    }

    @RequestMapping("checkName")
    @ResponseBody
    public boolean checkNickName(String nickName,Integer uid) throws Exception {
        System.out.println(nickName);
        System.out.println(uid);
        return sysUserService.checkNickName(nickName,uid);
    }

    @RequestMapping("list")
    public String listUser(@RequestParam(value = "kw",defaultValue = "") String kw,
                           @RequestParam(value = "cp",defaultValue = "1") Integer cp,
                           @RequestParam(value = "ls",defaultValue = "10") Integer ls,
                           Model model,String flag) throws Exception {
        Map<String, Object> map = sysUserService.findAllSplit(kw, cp, ls);
        model.addAttribute("map",map);
        if ("user".equals(flag)){
            return "userpages/user_list";
        }else if ("limits".equals(flag)){
            return "limit/userlimits_list";
        }
        return null;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest req){
        //退出登录就注销session
        req.getSession().invalidate();
        //然后跳转到登录页面
        return "login";
    }

    @RequestMapping("remove")
    @ResponseBody
    public boolean remove(Integer id,HttpServletRequest request) throws Exception {
        if (!super.isAuth("updateUserLimit",request)){
            return  false;
        }
        return  sysUserService.deleteUser(id);
    }

    /**
     * 修改用户数据
     * @param user
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public boolean updateUser(SysUser user,HttpServletRequest request) throws Exception{
        if (!super.isAuth("updateUserLimit",request)){
            return  false;
        }
        return sysUserService.updateUser(user);
    }

    @Override
    public String getDir() {
        return null;
    }
}
