package com.springboot.demo.controller;

import com.springboot.demo.service.ArticleListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ArticleListController {
    @Autowired
    ArticleListService articleListService;
    @RequestMapping("/queryArticleByPage")
    public Map queryArticleByPage(@RequestParam(defaultValue = "0")int p, String nav_id, String article_title){
        Map map = new HashMap();
        map.put("list", articleListService.queryArticleMapByPage(p,nav_id,article_title));
        map.put("rows", articleListService.queryArticleCount(nav_id,article_title));
        map.put("navList", articleListService.queryNavAll());
        return map;
    }


}
