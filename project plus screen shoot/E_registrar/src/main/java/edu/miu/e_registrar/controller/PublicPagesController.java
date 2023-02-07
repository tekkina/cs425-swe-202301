package edu.miu.e_registrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

