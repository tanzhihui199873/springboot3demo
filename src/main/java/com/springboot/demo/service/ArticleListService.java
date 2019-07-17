package com.springboot.demo.service;

import com.springboot.demo.model.Nav;
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
    public List<Map> queryArticleMapByPage(int p, String nav_id, String article_title) ;
    public int  queryArticleCount(String nav_id, String article_title);
    public  List<Nav> queryNavAll();

}
