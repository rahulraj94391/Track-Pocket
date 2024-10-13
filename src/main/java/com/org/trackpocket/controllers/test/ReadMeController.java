package com.org.trackpocket.controllers.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReadMeController {
    @GetMapping("/readme")
    public String serveReadMePage(){
        return "readme.html";
    }
}
