package org.uhms.oauth.controller;

import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

@RestController
@RequestMapping("/user/api")
public class UserController {

    @Resource
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/hello")
    public Principal user(Principal user) {
        return user;
    }
}