package com.springboot.demo.controller;

import com.springboot.demo.model.Article;
import com.springboot.demo.model.Nav;
import com.springboot.demo.model.Page;
import com.springboot.demo.service.ArticleService;
import com.springboot.demo.utils.MyFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 * @Date: 2019/7/18 23:50
 * @Version: 1.0
 **/

@Controller
@ResponseBody
public class AddArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("/api/queryNavAll" )
    public List<Nav> queryNavAll(){
        List<Nav> navs = articleService.queryNavAll();
        return navs;
    }

    @PostMapping("/api/insertArticle" )
    public boolean insertArticle( Article article){
        article.setArticle_id(UUID.randomUUID().toString());
        boolean b = articleService.insertArticle(article);
        return b;
    }
}
