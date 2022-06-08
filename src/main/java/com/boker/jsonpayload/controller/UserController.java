package com.boker.jsonpayload.controller;

import com.boker.jsonpayload.UserService;
import com.boker.jsonpayload.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
      @GetMapping("/list")
     public  Iterable<User>list(){
          return userService.list();
     }

}
