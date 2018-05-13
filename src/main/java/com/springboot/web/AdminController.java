package com.springboot.web;

import com.springboot.exception.ServiceExcetion;
import com.springboot.obj.User;
import com.springboot.provider.PasswordProvider;
import com.springboot.service.UserService;
import com.springboot.util.Constants;
import com.springboot.util.RedisUtil;
import com.springboot.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author zhangbenben on 2018/5/13 0013
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @ApiOperation("用户登陆")
    @RequestMapping(value = "/login.json",method = RequestMethod.POST)
    public Map<String,Object> login(ModelAndView modelAndView,
                                    @RequestBody Map<String,Object> jsonObject){
            String name = null;
            String password = null;
            User user = null;
            RedisUtil redisUtil = new RedisUtil();
            try {
                name = (String) jsonObject.get("name");
                password = (String) jsonObject.get("password");
            }
            catch (Exception e){
                throw new ServiceExcetion("参数格式错误");
        }

        if(StringUtils.isBlank(name) || StringUtils.isBlank(password)){
            modelAndView.addObject("errorMsg",Constants.ERROR_MESSAGE);
            modelAndView.addObject("errorCode",Constants.ERROR_CODE);
            return modelAndView.getModel();
        }
        if(redisTemplate.hasKey("test")){
            modelAndView.addObject("successMsg","登录成功");
            modelAndView.addObject("successCode",Constants.SUCCESS_CODE);
            return modelAndView.getModel();
        }
        user = userService.selectByName(name);
        if(user == null){
            modelAndView.addObject("errorMsg",Constants.USER_NULL);
            modelAndView.addObject("errorCode",Constants.ERROR_CODE);
            return modelAndView.getModel();
        }
        if(!(PasswordProvider.encrypt(password).equals(user.getPassword())
                && name.equals(user.getName()))){
                modelAndView.addObject("errorMsg","用户名或密码错误");
                modelAndView.addObject("errorCode",Constants.ERROR_CODE);
                return modelAndView.getModel();
        }
        redisTemplate.opsForValue().set("test",user,3600,TimeUnit.SECONDS);

        modelAndView.addObject("successMsg","登录成功");
        modelAndView.addObject("successCode",Constants.SUCCESS_CODE);
        return  modelAndView.getModel();
    }




}
