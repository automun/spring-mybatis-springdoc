package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void login(User user) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
        usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername()
        ,user.getPassword());

       Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

       if (Objects.isNull(authentication))
           throw new RuntimeException("登陆失败");

    }
}
