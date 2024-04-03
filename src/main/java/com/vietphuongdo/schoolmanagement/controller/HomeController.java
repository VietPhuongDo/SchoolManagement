package com.vietphuongdo.schoolmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {"/home","","/"})
    public String getHomePage(Model model){
        model.addAttribute("username","Phuong");
        return "home";
    }
}
