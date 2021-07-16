package com.example.vd.controller;

import com.example.vd.Result;
import com.example.vd.dao.DoctorRepository;
import com.example.vd.dao.UserReposity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@CrossOrigin
@RequestMapping(value = "/doctor")
public class DoctorController {

    public final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Result<?> getAll() {
        return new Result(doctorRepository.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "/findByOpenId", method = RequestMethod.GET)
    public Result<?> findByOpenId(@RequestParam(value = "open_id")String open_id) {
        return new Result(doctorRepository.findByOpenId(open_id));
    }

}
