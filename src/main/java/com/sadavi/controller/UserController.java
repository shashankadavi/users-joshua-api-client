package com.sadavi.controller;

import com.sadavi.bean.User;
import com.sadavi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequestMapping(path ="/user")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path ="/info")
    public ResponseEntity<User> getUserInfo() throws MalformedURLException {
        ResponseEntity<User> responseEntity = userService.getUserInfo();

        if (responseEntity.getBody() == null){
            return null;
        }
        return responseEntity;
    }

}
