package com.example.anzu.controller;

import com.example.anzu.Result;
import com.example.anzu.dao.ShopRepository;
import com.example.anzu.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/shop")
public class ShopController {
    public final ShopRepository shopRepository;

    public ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @ResponseBody
    @RequestMapping("/saveShop") //更新商家
    public Result<?> saveShop(@RequestBody Map<String, Object> queryBody) {
        Shop shop = new Shop();
        shop.setUid((String)queryBody.get("uid"));
        shop.setShopName((String)queryBody.get("shopName"));
        shop.setShopLogo((String)queryBody.get("shopLogo"));
        shop.setShopType((String)queryBody.get("shopType"));
        shop.setShopAddress((String)queryBody.get("shopAddress"));
        shop.setHolderName((String)queryBody.get("holderName"));
        shop.setHolderPhone((String) queryBody.get("holderPhone"));
        shopRepository.save(shop);
        return new Result(shop);
    }

    @ResponseBody
    @RequestMapping("/getByUid") //查询店铺信息
    public Result<?> getByUid(@RequestParam("uid") String uid) {
        Shop shop = shopRepository.findByUid(uid);
        if (shop == null) {
            return new Result(new Throwable("请求失败"));
        }
        return new Result(shop);
    }
}
