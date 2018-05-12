package com.springboot.web;

import com.springboot.obj.User;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbenben
 */
@RestController
public class HelloController {
   private Logger logger = LoggerFactory.getLogger(this.getClass());


   @ApiOperation("hello world")
   @RequestMapping("/hello")
   public String hello(){
      logger.info("test info");
      return "hello";

   }
}