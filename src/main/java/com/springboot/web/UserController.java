package com.springboot.web;

import com.alibaba.fastjson.JSONObject;
import com.springboot.exception.ServiceExcetion;
import com.springboot.obj.User;
import com.springboot.provider.PasswordProvider;
import com.springboot.service.UserService;
import com.springboot.util.Constants;
import com.springboot.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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
    @RequestMapping("/getUser.json")
    public Map<String,Object> getUser(@ApiParam(value = "用户id",required = true) Integer id
            ,ModelAndView modelAndView)  {
        User user = userService.selectByPrimaryKey(id);
        if(id == null){
            modelAndView.addObject("errorCode",Constants.ERROR_CODE);
            modelAndView.addObject("errorMessage",Constants.ERROR_MESSAGE);
            return modelAndView.getModel();
        }
        modelAndView.addObject("user",user);
        modelAndView.addObject("successCode",Constants.SUCCESS_CODE);
        modelAndView.addObject("successMessage",Constants.SUCCESS_MESSAGE);
        return modelAndView.getModel();
    }
    @ApiOperation("添加用户信息")
    @RequestMapping(value = "/addUser.json",method = RequestMethod.POST)
    public Map<String,Object> addUser(ModelAndView modelAndView,
                                      @RequestBody Map<String, Object> jsonObject) {
        logger.info("jsonObject的值为"+jsonObject);
        String name = null;
        String password = null;
        User user = new User();
        try {
            name = (String)jsonObject.get("name");
            password = (String)jsonObject.get("password");
        } catch (Exception e) {
            logger.info("参数填写有误");
            throw new ServiceExcetion("参数填写有误");

        }
        if (StringUtils.isBlank(name) || StringUtils.isBlank(password)){
                modelAndView.addObject("ERROR_CODE",Constants.ERROR_CODE);
                modelAndView.addObject("ERROR_MESSAGE",Constants.ERROR_MESSAGE);
                return modelAndView.getModel();
        }
        //这里还要加一个判断，用户名是否已经存在的问题
        logger.info("name姓名："+name);
        logger.info("密码password："+password);
        User validateUser = userService.selectByName(name);
        if(validateUser != null){
            modelAndView.addObject("ERROR_CODE",Constants.ERROR_CODE);
            modelAndView.addObject("ERROR_MESSAGE","用户名已存在");
            return modelAndView.getModel();
        }

        user.setName(name);
        user.setPassword(PasswordProvider.encrypt(password));

        userService.insert(user);

        modelAndView.addObject("SUCCESS_CODE",Constants.SUCCESS_CODE);
        modelAndView.addObject("SUCCESS_MESSAGE",Constants.SUCCESS_MESSAGE);
        return modelAndView.getModel();
    }
    @ApiOperation("更改用户信息")
    @RequestMapping(value = "/updateUser.json",method = RequestMethod.POST)
    public Map<String,Object> updateUser(ModelAndView modelAndView,@RequestBody Map<String,Object> jsonObject){
        logger.info("jsonObject的值为"+jsonObject);
        Integer id = null;
        String name = null;
        String password = null;
        User user = new User();
        try {
            id = (Integer)jsonObject.get("id");
            name = (String)jsonObject.get("name");
            password = (String)jsonObject.get("password");
        }
        catch (Exception e){
            logger.info("参数填写有误");
            throw new ServiceExcetion("参数填写有误");
        }
        if (StringUtils.isBlank(name) || StringUtils.isBlank(password)) {
            modelAndView.addObject("ERROR_CODE",Constants.ERROR_CODE);
            modelAndView.addObject("ERROR_MESSAGE",Constants.ERROR_MESSAGE);
            return modelAndView.getModel();
        }
        logger.info("name姓名："+name.toString());
        logger.info("密码password："+password.toString());
        user.setId(id);
        user.setName(name);
        user.setPassword(PasswordProvider.encrypt(password));

        userService.update(user);

        modelAndView.addObject("SUCCESS_CODE",Constants.SUCCESS_CODE);
        modelAndView.addObject("SUCCESS_MESSAGE",Constants.SUCCESS_MESSAGE);
        return modelAndView.getModel();

    }
    @ApiOperation("删除用户信息")
    @RequestMapping(value = "/deleteUser.json",method = RequestMethod.POST)
    public Map<String,Object> deleteUser(ModelAndView modelAndView,@RequestBody Map<String,Object> jsonObject){
        logger.info("jsonObject的值为"+jsonObject);
        Integer id = null;
        try {
            id = (Integer)jsonObject.get("id");

        }
        catch (Exception e){
            logger.info("参数填写有误");
            throw new ServiceExcetion("参数填写有误");
        }
        if (StringUtils.isBlank(id.toString())) {
            modelAndView.addObject("ERROR_CODE",Constants.ERROR_CODE);
            modelAndView.addObject("ERROR_MESSAGE",Constants.ERROR_MESSAGE);
            return modelAndView.getModel();
        }
        userService.deleteById(id);

        modelAndView.addObject("SUCCESS_CODE",Constants.SUCCESS_CODE);
        modelAndView.addObject("SUCCESS_MESSAGE",Constants.SUCCESS_MESSAGE);

        return modelAndView.getModel();
    }
    @ApiOperation("批量删除用户信息")
    @RequestMapping(value = "/batchdeleteUser.json",method = RequestMethod.POST)
    public Map<String,Object> batchdeleteUser(ModelAndView modelAndView,
                                         @RequestBody Map<String,Object> jsonObject){

        logger.info("jsonObject的值为"+jsonObject);
        List<Map<String,Object>> idList = (List<Map<String, Object>>) jsonObject.get("idList");
        List<Integer> newidList = new LinkedList<Integer>();
        if(idList.isEmpty()){
            modelAndView.addObject("ERROR_CODE",Constants.ERROR_CODE);
            modelAndView.addObject("ERROR_MESSAGE",Constants.ERROR_MESSAGE);
            return modelAndView.getModel();
        }

        for(Map<String,Object> map : idList){
            newidList.add((Integer)map.get("id"));
        }
        userService.deleteByList(newidList);
        modelAndView.addObject("SUCCESS_CODE",Constants.SUCCESS_CODE);
        modelAndView.addObject("SUCCESS_MESSAGE",Constants.SUCCESS_MESSAGE);

        return modelAndView.getModel();


        }

}
