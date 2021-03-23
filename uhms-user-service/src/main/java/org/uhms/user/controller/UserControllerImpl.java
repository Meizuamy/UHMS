package org.uhms.user.controller;

import javax.annotation.Resource;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.uhms.user.UserController;
import org.uhms.user.models.User;
import org.uhms.user.services.serviceImpl.UserServiceImpl;

import java.util.List;


@Controller
public class UserControllerImpl implements UserController {

    @Resource
    private UserServiceImpl userService;

    @GetMapping(value = "/")
    @ResponseBody
    public List<User> index(){
        return userService.getAllUser();
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public Integer createUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public Integer updateUser(@RequestBody User user){
       return userService.updateUser(user);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public List<User> getUserPage(@RequestParam(name = "page",defaultValue = "0")int page,@RequestParam(name = "size",defaultValue = "2")int size){
        return userService.pageUserList(page,size);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public Integer deleteUser(@RequestParam(value = "id")Long id){
        return userService.deleteUser(id);
    }
}
