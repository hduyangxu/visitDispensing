package com.example.vd.controller;

import com.example.vd.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
