package com.springboot.demo.controller;

import com.springboot.demo.model.Manager;
import com.springboot.demo.service.ManagerService;
import com.springboot.demo.service.impl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.controller
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/19 02:33
 * @Version: 1.0
 **/
@RestController
public class ManagerListController {
    @Autowired
    ManagerService managerService;
    @PostMapping("/api/queryManagerAll")
    public List<Manager>  queryManagerAll(){
        List<Manager> managers = managerService.queryManagerAll();
        return managers;
    };
}
