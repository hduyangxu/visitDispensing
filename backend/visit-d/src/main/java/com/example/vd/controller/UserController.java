package com.example.vd.controller;

import com.example.vd.Result;
import com.example.vd.dao.UserReposity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@Transactional
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    public final UserReposity userReposity;

    public UserController(UserReposity userReposity) {
        this.userReposity = userReposity;
    }

    @ResponseBody
    @RequestMapping(value = "/findByOpenId", method = RequestMethod.GET)
    public Result<?> findByOpenId(@RequestParam(value = "open_id")String open_id) {
        return new Result(userReposity.findByOpenId(open_id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> addUser(@RequestParam(value = "open_id")String open_id,
                             @RequestParam(value = "phone")String phone) {
        if (userReposity.findByOpenId(open_id).size() == 0) {
            userReposity.addUser(open_id, phone);
            return new Result();
        } else {
            return new Result(new Throwable("该用户已存在"));
        }
    }

}
