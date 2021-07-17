package com.example.vd.controller;

import com.example.vd.Result;
import com.example.vd.dao.DoctorRepository;
import com.example.vd.entity.DoctorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@RestController
@CrossOrigin
@RequestMapping(value = "/doctor")
public class DoctorController {

    public final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // 获取所有医生
    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Result<?> getAll() {
        return new Result(doctorRepository.findAll());
    }

    // 根据id获取医生
    @ResponseBody
    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public Result<?> findOne(@RequestParam(value = "id")int id) {
        return new Result(doctorRepository.findOne(id));
    }

    // 根据openid获取医生
    @ResponseBody
    @RequestMapping(value = "/findByOpenId", method = RequestMethod.GET)
    public Result<?> findByOpenId(@RequestParam(value = "open_id")String open_id) {
        return new Result(doctorRepository.findByOpenId(open_id));
    }

    // 医生分页查询
    @ResponseBody
    @RequestMapping(value = "/findByPage", method = RequestMethod.GET)
    public Result<?> findByPage(@RequestParam(value = "page")int page,
                                @RequestParam(value = "size")int size) {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");//排序方法使用Sort.by，不能使用new Sort()
        Pageable pageable = PageRequest.of(page - 1, size, sort);//第几页，每页几条数据
        Page<DoctorEntity> myPage = doctorRepository.findAll(pageable);//自带方法 findAll()
        List<DoctorEntity> list = myPage.getContent();
        Map data = new HashMap();
        data.put("totalPages", myPage.getTotalPages());
        data.put("totalElements", myPage.getTotalElements());
        data.put("content", list);
        return new Result(data);
    }

}
