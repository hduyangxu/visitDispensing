package com.example.vd.controller;

import com.example.vd.Result;
import com.example.vd.dao.ConsultRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
@RestController
@CrossOrigin
@RequestMapping(value = "/consult")
public class ConsultController {

    public final ConsultRepository consultRepository;

    public ConsultController(ConsultRepository consultRepository) {
        this.consultRepository = consultRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public Result<?> findByUserId(@RequestParam(value = "id")int id) {
        return new Result(consultRepository.findByUserId(id));
    }

    @ResponseBody
    @RequestMapping(value = "/findByDoctorId", method = RequestMethod.GET)
    public Result<?> findByDoctorId(@RequestParam(value = "id")int id) {
        return new Result(consultRepository.findByDoctorId(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> addUser(@RequestParam(value = "name")String name,
                             @RequestParam(value = "gender")int gender,
                             @RequestParam(value = "age")int age,
                             @RequestParam(value = "id_number")String id_number,
                             @RequestParam(value = "phone")String phone,
                             @RequestParam(value = "user_id")int user_id,
                             @RequestParam(value = "doc_id")int doc_id,
                             @RequestParam(value = "diag")String diag,
                             @RequestParam(value = "drug_ids")String drug_ids,
                             @RequestParam(value = "des")String des,
                             @RequestParam(value = "pics")String pics) {
        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp time = Timestamp.valueOf(current);
        consultRepository.addConsult(name, gender, age, id_number, phone, user_id, doc_id, diag, drug_ids, des, pics, time);
        return new Result();
    }

    @ResponseBody
    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public Result<?> finish(@RequestParam(value = "id")int id) {
        consultRepository.modifyStatus(id);
        return new Result();
    }

}
