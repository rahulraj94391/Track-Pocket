package com.org.trackpocket.controllers.error;

import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController implements ErrorController {
    @GetMapping(value = "/error")
    public String error(HttpServletRequest request) {
        return "error.html";
    }
}
