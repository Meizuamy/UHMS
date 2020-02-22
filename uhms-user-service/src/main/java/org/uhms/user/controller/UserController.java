package org.uhms.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.uhms.user.models.User;
import org.uhms.user.services.serviceImpl.UserServiceImpl;



@Controller
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("users",userService.getAllUser());
        return "index";
    }
    @GetMapping(value = "/create")
    public String createIndex(){
        return "createAndUpdate";
    }

    @GetMapping(value = "/update")
    public String updateIndex(){
        return "createAndUpdate";
    }

    @PostMapping(value = "/create")
    public String createUser(User user){
        userService.save(user);
        return "redirect:/";
    }
    @PostMapping(value = "/update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/";
    }
}
