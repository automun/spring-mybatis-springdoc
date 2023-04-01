package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "没有找到对应id的书籍")
public class myNotFoundException extends RuntimeException{
    public myNotFoundException() {

    }
}
