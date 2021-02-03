package com.yn.pms.controller;

import com.yn.pms.entity.SellContract;
import com.yn.pms.service.ISellContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/2/3-10:17
 */
@Controller
@RequestMapping("/sellContract/*")
public class SellContractController extends BaseController {

    @Resource
    private ISellContractService sellContractService;

    @RequestMapping("add")
    @ResponseBody
    public boolean addSellController(SellContract sellContract)throws Exception{
        return sellContractService.createSellContract(sellContract);
    }

    @RequestMapping("upload")
    @ResponseBody
    public String upload(HttpServletRequest request, @RequestParam("file")MultipartFile file) throws Exception{
        return super.saveFile(request,file);
    }

    @RequestMapping("list")
    public String getRoomList(Integer cid,Integer bid,Integer fid,Integer status,@RequestParam(value = "cp",defaultValue = "1") Integer cp,
                              @RequestParam(value = "ls",defaultValue = "10") Integer ls, Model model) throws Exception{

        model.addAttribute("roomMap",sellContractService.findAllRooms(cid,bid,fid,status,cp,ls));
        return "sellConstract/sellConstract";
    }


    @RequestMapping("lookSellContract")
    public String getSellContract(Integer rid,Model model) throws Exception{
        SellContract sellContract = sellContractService.findByRid(rid);
        model.addAttribute("sellContract",sellContract);
        return "res/residence_sell_view.html";
    }
    @Override
    public String getDir() {
        return "sellContract/";
    }
}
