package com.example.vd.controller;

import com.example.vd.Result;
import com.example.vd.dao.PresDrugRepository;
import com.example.vd.dao.PresInfoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
@RestController
@CrossOrigin
@RequestMapping(value = "/pres_drug")
public class PresDrugController {

    public final PresDrugRepository presDrugRepository;

    public PresDrugController(PresDrugRepository presDrugRepository) {
        this.presDrugRepository = presDrugRepository;
    }

    // 根据处方表id获取药品
    @ResponseBody
    @RequestMapping(value = "/findByPresId", method = RequestMethod.GET)
    public Result<?> findByPresId(@RequestParam(value = "id")int id) {
        return new Result(presDrugRepository.findByPresId(id));
    }

    // 根据id获取药品信息
    @ResponseBody
    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public Result<?> findOne(@RequestParam(value = "id")int id) {
        return new Result(presDrugRepository.findOne(id));
    }

    // 新增药品
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> add(@RequestParam(value = "pres_id")int pres_id,
                         @RequestParam(value = "drug_name")String drug_name,
                         @RequestParam(value = "dose")String dose,
                         @RequestParam(value = "dose_unit")String dose_unit,
                         @RequestParam(value = "frequency")String frequency,
                         @RequestParam(value = "drug_usage")String drug_usage,
                         @RequestParam(value = "take_days")int take_days,
                         @RequestParam(value = "quantity")int quantity,
                         @RequestParam(value = "price")double price,
                         @RequestParam(value = "remark")String remark) {
        return new Result(presDrugRepository.addPresDrug(pres_id, drug_name, dose, dose_unit, frequency, drug_usage, take_days, quantity, price, remark));
    }

    // 删除药品
    @ResponseBody
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Result<?> deleteById(@RequestParam(value = "id")int id) {
        return new Result(presDrugRepository.deleteById(id));
    }
}
