package com.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbenben
 */
@RestController
public class HelloController {
   @RequestMapping("/hello")
   public String hello(){
      return "hello";
   }
}
