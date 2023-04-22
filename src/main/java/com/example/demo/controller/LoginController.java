package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-app")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody User user)
    {
        loginService.login(user);
    }

}
