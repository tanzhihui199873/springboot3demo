package com.springboot.demo.mapper;

import com.springboot.demo.model.Manager;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.mapper
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/19 02:28
 * @Version: 1.0
 **/
@Component
public interface ManagerMapper {
    List<Manager> queryManagerAll();
}
