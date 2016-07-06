package com.apple.springmvc.controller;

import com.apple.springmvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renxueni on 2016/7/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/getUserList")
    public String getUserList(){
        return "/hello";
    }

    @RequestMapping(value = "/getAllUser", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> getUser(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("users",userService.getAllUser());
        return result;
    }
}
