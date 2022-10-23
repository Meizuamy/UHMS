package org.uhms.user;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.uhms.user.models.User;

@FeignClient(value="User")
public interface UserApi {

    @GetMapping("/")
    @ResponseBody
    public List<User> index();


    @PostMapping("/create")
    @ResponseBody
    public int createUser(@RequestBody User user);


    @PutMapping("/update")
    @ResponseBody
    public int updateUser(@RequestBody User user);

    @GetMapping("/list")
    @ResponseBody
    public List<User> getUserPage(@RequestParam(name = "page",defaultValue = "0") int page, 
                                    @RequestParam(name="size", defaultValue = "10") int size);

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public int deleteUser(@RequestParam(value="id") int id);
}
