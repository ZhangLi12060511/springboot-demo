package com.springboot.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbenben
 */
@RestController
public class HelloController {
   @ApiOperation("hello world")
   @RequestMapping("/hello")
   public String hello(){
      return "hello";
   }
}
