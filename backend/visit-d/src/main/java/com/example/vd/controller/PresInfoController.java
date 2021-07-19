package com.example.vd.controller;

import com.example.vd.Result;
import com.example.vd.dao.PresInfoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
@RestController
@CrossOrigin
@RequestMapping(value = "/pres_info")
public class PresInfoController {

    public final PresInfoRepository presInfoRepository;

    public PresInfoController(PresInfoRepository presInfoRepository) {
        this.presInfoRepository = presInfoRepository;
    }

    // 根据申请表id获取处方表
    @ResponseBody
    @RequestMapping(value = "/findByConsultId", method = RequestMethod.GET)
    public Result<?> findByConsultId(@RequestParam(value = "id")int id) {
        return new Result(presInfoRepository.findByConsultId(id));
    }

    // 根据id获取处方表
    @ResponseBody
    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public Result<?> findOne(@RequestParam(value = "id")int id) {
        return new Result(presInfoRepository.findOne(id));
    }

    // 新增处方表
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> add(@RequestParam(value = "user_id")int user_id,
                         @RequestParam(value = "consult_id")int consult_id,
                         @RequestParam(value = "type")char type,
                         @RequestParam(value = "doctor_id")int doctor_id,
                         @RequestParam(value = "doctor_name")String doctor_name) {
        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp time = Timestamp.valueOf(current);
        return new Result(presInfoRepository.addPresInfo(user_id, consult_id, type, doctor_id, doctor_name, time));
    }

    // 删除处方表
    @ResponseBody
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Result<?> deleteById(@RequestParam(value = "id")int id) {
        return new Result(presInfoRepository.deleteById(id));
    }

    // 修改处方表状态为已提交
    @ResponseBody
    @RequestMapping(value = "/modifyStatus", method = RequestMethod.POST)
    public Result<?> modifyStatus(@RequestParam(value = "id")int id) {
        return new Result(presInfoRepository.modifyStatus(id));
    }

}
