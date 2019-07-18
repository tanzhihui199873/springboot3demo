package com.springboot.demo.service.impl;

import com.springboot.demo.mapper.ManagerMapper;
import com.springboot.demo.model.Manager;
import com.springboot.demo.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.service.impl
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/19 02:27
 * @Version: 1.0
 **/
@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    ManagerMapper managerMapper;
    public List<Manager> queryManagerAll(){
        List<Manager> managers = managerMapper.queryManagerAll();
        return managers;
    };
}
