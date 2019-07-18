package com.springboot.demo.controller;

import com.springboot.demo.model.Article;
import com.springboot.demo.model.Nav;
import com.springboot.demo.service.ArticleService;
import com.springboot.demo.utils.MyFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.controller
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/19 00:48
 * @Version: 1.0
 **/

@Controller
@ResponseBody
public class EditArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("/api/queryArticleMap4Edit" )
    public Map queryArticleMap4Edit(String article_id){
        Map map = new HashMap();
        map.put("navList", articleService.queryNavAll());//查询出所有的分类List
        map.put("article", articleService.queryArticleById(article_id));//根据新闻的主键ID查询出此条新闻 article
        return map;
    }
    @PostMapping("/api/editArticle" )
    public boolean editArticle(Article article) {
        boolean b = articleService.editArticle(article);
        return b;
    }
}

