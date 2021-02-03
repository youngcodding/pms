package com.yn.pms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yn
 * @class pms
 * @describe
 * @date 2021/1/27-10:30
 */
@Controller
public class TestController {

    @GetMapping("index")
    public String test(){
        return "home";
    }
}
