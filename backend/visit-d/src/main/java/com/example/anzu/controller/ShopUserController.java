package com.example.anzu.controller;

import com.example.anzu.Result;
import com.example.anzu.dao.ShopUserRepository;
import com.example.anzu.entity.ShopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/shopUser")
public class ShopUserController {
    public final ShopUserRepository shopUserRepository;

    public ShopUserController(ShopUserRepository shopUserRepository) {
        this.shopUserRepository = shopUserRepository;
    }

    @ResponseBody
    @RequestMapping("/getAll") //查询所有商家用户信息
    public Result<?> findAllShopUser() {
        List<ShopUser> shopUsers = new ArrayList<ShopUser>();
        shopUsers = shopUserRepository.findAll();
        return new Result(shopUsers);
    }

    @ResponseBody
    @RequestMapping("/login") //商家用户登录
    public Result<?> shopUserLogin(@RequestParam("cellphone") String cellphone,
                                   @RequestParam("password") String password) {
        ShopUser shopUser = shopUserRepository.findByCellphoneAndPassword(cellphone, password);
        if (shopUser == null) {
            return new Result(new Throwable("用户名或密码错误"));
        }
        return new Result(shopUser);
    }

    @ResponseBody
    @RequestMapping("/saveShopUser") //商家用户注册
    public Result<?> saveShopUser(@RequestParam("cellphone") String cellphone,
                                  @RequestParam("password") String password) {
        ShopUser shopUser = shopUserRepository.findByCellphone(cellphone);
        if (shopUser == null) {
            shopUser = new ShopUser();
            shopUser.setUid(UUID.randomUUID().toString());
            shopUser.setCellphone(cellphone);
            shopUser.setPassword(password);
            shopUserRepository.save(shopUser);
            return new Result(shopUser);
        }
        return new Result(new Throwable("手机号已注册,请直接登录"));
    }
}
