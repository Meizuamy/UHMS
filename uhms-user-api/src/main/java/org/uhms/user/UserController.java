package org.uhms.user;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="User")
public interface UserController {




}
