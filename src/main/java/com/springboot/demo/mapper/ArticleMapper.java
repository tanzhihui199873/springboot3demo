package com.springboot.demo.mapper;

import com.springboot.demo.model.Article;
import com.springboot.demo.model.Nav;
import com.springboot.demo.model.Page;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.mapper
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/17 20:32
 * @Version: 1.0
 **/
@Component
public interface ArticleMapper {
    List<Map> queryArticleMapByPage(Page page) ;
    int  queryArticleCount(Page page);
    List<Nav> queryNavAll();
    boolean insertArticle(Article article);
}
