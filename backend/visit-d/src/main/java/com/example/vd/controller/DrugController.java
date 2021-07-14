package com.example.vd.controller;

import com.example.vd.Result;
import com.example.vd.dao.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/drug")
public class DrugController {

    public final DrugRepository drugRepository;

    public DrugController(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    // 获取所有药品信息
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Result<?> getAll() {
        return new Result(drugRepository.findAll());
    }

}
