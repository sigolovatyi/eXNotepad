package com.sigolovatyi.note.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/wrong")
    public String wrong(){
        return "smth_wrong";
    }
}
