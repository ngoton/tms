package com.tinhoctainha.tms.security.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping(path = "/login")
    public String login(){
        return "login";
    }
}
