package com.springboot.demo.service;

import com.springboot.demo.model.Nav;
import com.springboot.demo.model.Page;
import org.springframework.http.HttpRequest;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.service
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/17 20:33
 * @Version: 1.0
 **/

public interface ArticleListService {
     List<Map> queryArticleMapByPage(int p,Page page) ;
     int  queryArticleCount(Page page);
      List<Nav> queryNavAll();

}
