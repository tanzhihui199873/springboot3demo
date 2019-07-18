package com.springboot.demo.service;

import com.springboot.demo.model.Manager;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.service
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/19 02:28
 * @Version: 1.0
 **/

public interface ManagerService {
    List<Manager> queryManagerAll();
}
