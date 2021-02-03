package com.yn.pms.controller;

import com.yn.pms.entity.Permission;
import com.yn.pms.entity.SysUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/27-17:03
 */
public abstract class BaseController {



    @InitBinder
    public void initBinder(WebDataBinder binder){
        //创建一个日期格式化类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //追加一个自定义的转换器，遇到java.util.Date.class类型会按照定义好的SimpleDateFormat类进行转换
        binder.registerCustomEditor(java.util.Date.class,new CustomDateEditor(sdf,false));
    }

    public boolean isAuth(String opreationName, HttpServletRequest request){
        //从session中获取用户信息
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        //获取权限信息
        Permission permission = user.getPermission();
        Class<? extends Permission> aClass = permission.getClass();
        Integer per = 0;
        try {
            Field field = aClass.getDeclaredField(opreationName);
            field.setAccessible(true);
            per = (Integer) field.get(permission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return per==1;
    }

    /**
     * 父类的上传方法
     * @param request
     * @param photo
     * @return
     * @throws Exception
     */
    public String saveFile(HttpServletRequest request, MultipartFile photo) throws Exception{
        //图片上传的路径
        String path = request.getServletContext().getRealPath("/")+this.getDir();
        //生成图片新名称
        String fileName = UUID.randomUUID().toString().replace("-","");
        //取得原文件的扩展名
        String originalFilename = photo.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        //创建file对象
        File file = new File(path+fileName+ext);
        System.out.println("文件地址："+path+fileName+ext);
        //判断文件的文件夹是否存在
        if (!file.getParentFile().exists()){
            file.mkdirs();
        }
        //保存图片
        photo.transferTo(file);
        //返回图片的相对路径地址
        return this.getDir()+fileName+ext;
    }


    /**
     * 删除指定文件名的文件
     * @param request
     * @param fileNames
     */
    public void remove(HttpServletRequest request,String... fileNames){
        String [] files=fileNames;
        for (String fileName : files) {
            String path = request.getServletContext().getRealPath("/") + fileName;
            File file = new File(path);
            if (file.exists()){
                file.delete();
            }
        }

    }

    public abstract String getDir();
}
