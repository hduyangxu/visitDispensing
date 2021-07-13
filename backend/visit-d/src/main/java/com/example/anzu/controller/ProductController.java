package com.example.anzu.controller;

import com.example.anzu.Result;
import com.example.anzu.dao.ProductRepository;
import com.example.anzu.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    public final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 获取所有商品
    @ResponseBody
    @RequestMapping("/getAll")
    public Result<?> getAll() {
        return new Result(productRepository.findAll());
    }

    // 根据商家id获取商品列表
    @ResponseBody
    @RequestMapping("/getByUid")
    public Result<?> getByUid(@RequestParam("uid") String uid) {
        List<Product> products = productRepository.findByUid(uid);
        return new Result(products);
    }

    @ResponseBody
    @RequestMapping("/saveProduct") //上架新商品
    public Result<?> saveProduct(@RequestBody Map<String, Object> queryBody) {
        Product product = new Product();
        product.setUid((String) queryBody.get("uid"));
        product.setGoodsMain((String) queryBody.get("goodsMain"));
        product.setGoodsSub((String) queryBody.get("goodsSub"));
        product.setGoodsType((String) queryBody.get("goodsType"));
        product.setGoodsDetail((String) queryBody.get("goodsDetail"));
        product.setGoodsRule((String) queryBody.get("goodsRule"));
        product.setGoodsPriceContent((String) queryBody.get("goodsPriceContent"));
        product.setGoodsPriceDate((String) queryBody.get("goodsPriceDate"));
        product.setGoodsInventory((String) queryBody.get("goodsInventory"));
        product.setGoodsMode((String) queryBody.get("goodsMode"));
        product.setGoodsCover((String) queryBody.get("goodsCover"));
        productRepository.save(product);
        return new Result(product);
    }
}
