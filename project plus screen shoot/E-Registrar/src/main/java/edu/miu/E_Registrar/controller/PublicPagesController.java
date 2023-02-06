package edu.miu.E_Registrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PublicPagesController {
    @GetMapping(value = "/")
    public String displayHomePage(){
        return "public/index";
    }
    @GetMapping(value ="/menu" )
    public String displayMenu(){
        return "/public/menu";
    }
}

