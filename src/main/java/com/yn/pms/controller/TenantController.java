package com.yn.pms.controller;

import com.yn.pms.entity.Tenant;
import com.yn.pms.service.ITenantService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/1-9:18
 */
@Controller
@RequestMapping("/tenant/*")
public class TenantController extends BaseController {

    @Resource
    private ITenantService tenantService;

    @RequestMapping("add")
    @ResponseBody
    public boolean addTenant(Tenant tenant) throws Exception{
        return tenantService.saveTenant(tenant);
    }

    @RequestMapping("update")
    @ResponseBody
    public boolean updateTenant(Tenant tenant) throws Exception{
        return tenantService.updateTenant(tenant);
    }


    @RequestMapping("remove")
    @ResponseBody
    @Transactional
    public boolean removeTenant(HttpServletRequest request,Integer id,String identitynegative,String identitypositive) throws Exception{
        boolean flag = tenantService.deleteTenant(id);
        if (flag){
            try {
                super.remove(request,identitynegative,identitypositive);
            } catch (Exception e) {
                e.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }

    @RequestMapping("list")
    public String getTenants(@RequestParam(value = "kw",defaultValue = "") String kw,
                             @RequestParam(value = "cp",defaultValue = "1") Integer cp,
                             @RequestParam(value = "ls",defaultValue = "10") Integer ls,
                             Model model) throws Exception{
        Map<String, Object> tenantMap = tenantService.findBySplit(kw, cp, ls);
        model.addAttribute("tenantMap",tenantMap);
        return "tenants/tenant_list";
    }

    @RequestMapping("uploadFile")
    @ResponseBody
    public String upload(HttpServletRequest request,@RequestParam("file") MultipartFile file) throws  Exception{
        System.out.println(file);
        return super.saveFile(request,file);
    }

    @Override
    public String getDir() {
        return "tenant/";
    }
}
