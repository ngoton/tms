package com.tinhoctainha.tms.backoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping(path = "/admin")
    public String index(){
        return "admin/index/index";
    }
}
