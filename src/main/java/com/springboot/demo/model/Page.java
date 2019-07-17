package com.springboot.demo.model;

/**
 * @ProjectName: demo
 * @Package: com.springboot.demo.model
 * @apiDescription
 * @Author: 智慧
 * @Date: 2019/7/17 21:30
 * @Version: 1.0
 **/

public class Page {
    private int start;
    private int perPage;
    private String nav_id;
    private String article_title;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public String getNav_id() {
        return nav_id;
    }

    public void setNav_id(String nav_id) {
        this.nav_id = nav_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }
}
