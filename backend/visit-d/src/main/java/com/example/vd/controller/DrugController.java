package com.example.vd.controller;

import com.example.vd.Result;
import com.example.vd.dao.DrugRepository;
import com.example.vd.entity.DrugEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 药品分页查询
    @ResponseBody
    @RequestMapping(value = "/findByPage", method = RequestMethod.GET)
    public Result<?> findByPage(@RequestParam(value = "page")int page,
                                @RequestParam(value = "size")int size) {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");//排序方法使用Sort.by，不能使用new Sort()
        Pageable pageable = PageRequest.of(page - 1, size, sort);//第几页，每页几条数据
        Page<DrugEntity> myPage = drugRepository.findAll(pageable);//自带方法 findAll()
        List<DrugEntity> list = myPage.getContent();
        Map data = new HashMap();
        data.put("totalPages", myPage.getTotalPages());
        data.put("totalElements", myPage.getTotalElements());
        data.put("content", list);
        return new Result(data);
    }

    // 新增药品
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<?> add(@RequestParam(value = "drug_name")String drug_name,
                         @RequestParam(value = "trade_name")String trade_name,
                         @RequestParam(value = "pinyin_code")String pinyin_code,
                         @RequestParam(value = "specification")String specification,
                         @RequestParam(value = "pack_unit")char pack_unit,
                         @RequestParam(value = "price")double price,
                         @RequestParam(value = "dose")double dose,
                         @RequestParam(value = "dose_unit")String dose_unit,
                         @RequestParam(value = "factory_name")String factory_name,
                         @RequestParam(value = "approval_number")String approval_number) {
        return new Result(drugRepository.addDrug(drug_name, trade_name, pinyin_code, specification, pack_unit, price, dose, dose_unit, factory_name, approval_number));
    }

    // 修改药品
    @ResponseBody
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Result<?> modify(@RequestParam(value = "drug_name")String drug_name,
                            @RequestParam(value = "trade_name")String trade_name,
                            @RequestParam(value = "pinyin_code")String pinyin_code,
                            @RequestParam(value = "specification")String specification,
                            @RequestParam(value = "pack_unit")char pack_unit,
                            @RequestParam(value = "price")double price,
                            @RequestParam(value = "dose")double dose,
                            @RequestParam(value = "dose_unit")String dose_unit,
                            @RequestParam(value = "factory_name")String factory_name,
                            @RequestParam(value = "approval_number")String approval_number,
                            @RequestParam(value = "id")int id) {
        return new Result(drugRepository.modifyDrug(drug_name, trade_name, pinyin_code, specification, pack_unit, price, dose, dose_unit, factory_name, approval_number, id));
    }

    // 删除药品
    @ResponseBody
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Result<?> deleteById(@RequestParam(value = "id")int id) {
        return new Result(drugRepository.deleteById(id));
    }
}
