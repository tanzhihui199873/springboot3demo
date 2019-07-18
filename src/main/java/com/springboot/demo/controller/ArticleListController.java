package com.springboot.demo.controller;

import com.springboot.demo.model.Page;
import com.springboot.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class ArticleListController {
    @Autowired
    ArticleService articleService;
    @PostMapping("/api/queryArticleByPage" )
    public Map queryArticleByPage(@RequestParam(defaultValue = "0")int p, String nav_id, String article_title){
        Map map = new HashMap();
        Page page = new Page();

        page.setNav_id(nav_id);
        page.setArticle_title(article_title);
        map.put("list", articleService.queryArticleMapByPage(p,page));
        map.put("rows", articleService.queryArticleCount(page));
        map.put("navList", articleService.queryNavAll());
        return map;
    }


}
