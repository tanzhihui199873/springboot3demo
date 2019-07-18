package com.springboot.demo.service.impl;

import com.springboot.demo.mapper.ArticleMapper;
import com.springboot.demo.model.Article;
import com.springboot.demo.model.Nav;
import com.springboot.demo.model.Page;
import com.springboot.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.service.impl
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/17 20:33
 * @Version: 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    private int perPage = 10;
    @Autowired
    ArticleMapper articleMapper;
    public List<Map> queryArticleMapByPage(int p,Page page) {
        int start = p*perPage;
        int ii = start+1;
        page.setStart(start);
        page.setPerPage(perPage);
        List<Map> maps = articleMapper.queryArticleMapByPage(page);
        return maps;
    }
    public int  queryArticleCount(Page page){
        int i = articleMapper.queryArticleCount(page);
        return i;
    }
    public  List<Nav> queryNavAll(){
        List<Nav> navs = articleMapper.queryNavAll();
        return navs;
    }
    public boolean insertArticle(Article article){
        boolean b = articleMapper.insertArticle(article);
        return b;
    }
}
