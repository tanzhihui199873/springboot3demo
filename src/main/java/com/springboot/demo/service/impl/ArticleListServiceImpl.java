package com.springboot.demo.service.impl;

import com.springboot.demo.mapper.ArticleListMapper;
import com.springboot.demo.model.Nav;
import com.springboot.demo.model.Page;
import com.springboot.demo.service.ArticleListService;
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
public class ArticleListServiceImpl implements ArticleListService {
    private int perPage = 10;
    @Autowired
    ArticleListMapper articleListMapper;
    public List<Map> queryArticleMapByPage(int p, String nav_id, String article_title) {
        Page page = new Page();
        int start = p*perPage;
        int ii = start+1;
        page.setStart(start);
        page.setPerPage(perPage);
        page.setNav_id(nav_id);
        page.setArticle_title(article_title);
        List<Map> maps = articleListMapper.queryArticleMapByPage(page);
        return maps;
    }
    public int  queryArticleCount(String nav_id,String article_title){
        return 0;
    }
    public  List<Nav> queryNavAll(){
        return null;
    }

}
