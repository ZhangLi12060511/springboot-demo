package com.springboot.web;

import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangbenben
 */
@RestController
public class HelloController {
   private static final Logger logger = Logger.getLogger(HelloController.class);
   @ApiOperation("hello world")
   @RequestMapping("/hello")
   public String hello(){
      logger.info("hello 测试日志");
      return "hello";
   }
}
