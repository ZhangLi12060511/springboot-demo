package com.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private  void  test(){
        System.out.print("hello world");
    }
}
