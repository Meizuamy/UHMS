package org.uhms.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/myLogin.html")
    public String Login(){
        return "myLogin";
    }
}
