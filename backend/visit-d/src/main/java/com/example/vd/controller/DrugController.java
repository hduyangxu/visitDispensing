package com.example.vd.controller;

import com.example.vd.Result;
import com.example.vd.dao.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/drug")
public class DrugController {

    public final DrugRepository drugRepository;

    public DrugController(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    // 根据id获取药品信息
    @ResponseBody
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Result<?> findById(@RequestParam(value = "id")int id) {
        return new Result(drugRepository.findById(id));
    }

    // 获取所有药品信息
    @ResponseBody
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Result<?> findAll() {
        return new Result(drugRepository.findAll());
    }

    // 根据code模糊查询
    @ResponseBody
    @RequestMapping(value = "/findByCodeLike", method = RequestMethod.GET)
    public Result<?> findByCodeLike(@RequestParam(value = "code")String code) {
        return new Result(drugRepository.findByCodeLike(code));
    }

    // 根据名字模糊查询
    @ResponseBody
    @RequestMapping(value = "/findByNameLike", method = RequestMethod.GET)
    public Result<?> findByNameLike(@RequestParam(value = "name")String name) {
        return new Result(drugRepository.findByNameLike(name));
    }


}
