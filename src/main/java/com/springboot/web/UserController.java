package com.springboot.web;

import com.springboot.obj.User;
import com.springboot.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author zhangbenben on 2018/5/12 0012
 */
@RestController
@RequestMapping("/admin")
public class UserController {
    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @ApiOperation("获取用户信息")
    @RequestMapping("/user")
    public Map<String,Object> getUser(@ApiParam(value = "用户id",required = true) Integer id
            ,ModelAndView modelAndView)  {
        User user = userService.selectByPrimaryKey(id);
        modelAndView.addObject("user",user);
        return modelAndView.getModel();
    }

}
