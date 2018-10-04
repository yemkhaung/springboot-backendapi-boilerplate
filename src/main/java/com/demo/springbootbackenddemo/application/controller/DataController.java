package com.demo.springbootbackenddemo.application.controller;

import java.util.List;

import com.demo.springbootbackenddemo.application.entity.dto.DataDto;
import com.demo.springbootbackenddemo.application.service.DataQueryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class DataController {

    private DataQueryService dataQueryService;

    @Autowired
    public DataController(DataQueryService dataQueryService) {
        this.dataQueryService = dataQueryService;
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<DataDto> dataList = this.dataQueryService.index().get();
        model.addAttribute("dataList", dataList);
        return "data/list";
    }

    @RequestMapping(value = "/show/{id}")
    public String show(Model model, @PathVariable String id) {
        DataDto data = this.dataQueryService.findById(id).get();
        model.addAttribute("data", data);
        return "data/show";
    }

    @RequestMapping(value = "/new")
    public String newData() {
        return "data/new";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(Model model, @PathVariable String id) {
        DataDto data = this.dataQueryService.findById(id).get();
        model.addAttribute("data", data);
        return "data/edit";
    }

    @RequestMapping(value = "/remove/{id}")
    public String remove(Model model, @PathVariable String id) {
        DataDto data = this.dataQueryService.findById(id).get();
        model.addAttribute("data", data);
        return "data/remove";
    }
}