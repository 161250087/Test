package com.test.demo.controller;


import com.test.demo.service.ArticleService;
import com.test.demo.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    /**
     *@Author : LML
     *@Date : 15:49 2019/5/26
     *@Desciption : 查询所有文章的数量
     */
    @GetMapping("/getTotal")
    public int getAllArticlesCount(){
        return articleService.freshArticleNum();
    }


    /**
     *@Author : LML
     *@Date : 15:49 2019/5/26
     *@Desciption : 根据index每次查询5个
     * @param index
     *@return :  文章集合
     */
    @GetMapping("/getArticles/{index}")
    public String getArticesByIndex(@PathVariable int index){
        return new JSONArray(articleService.freshArticlePage(index*5,5)).toString();
    }




    @GetMapping("/getTotalByKeyword/{keyoword}")
    public int getAllArticlesCount(@PathVariable String keyword){
        return articleService.findFreshArticleNum(keyword);
    }

    @GetMapping("/getArticlesByKeyword/{keyword}/{index}")
    public String getArticesByIndexAndKeyword(@PathVariable String keyword,@PathVariable int index){

        return new JSONArray(articleService.findFreshArticlePage(keyword,index*5,5)).toString();
    }



    @GetMapping("/getTotalByKTag/{keyoword}")
    public int getAllArticlesCountByTag(@PathVariable String keyword){
        return articleService.findFreshArticleNum(keyword);
    }

    @GetMapping("/getArticlesByTag/{keyword}/{index}")
    public String getArticesByIndexAndTag(@PathVariable String keyword,@PathVariable int index){
        return new JSONArray(articleService.findFreshArticlePage(keyword,index*5,5)).toString();
    }


    /**
     *@Author : LML
     *@Date : 19:45 2019/5/26
     *@Desciption : 根据关键词获取热点文章
     * @param keyword
     *@return : res
     */
    @GetMapping("/getHotArticle/{keyword}")
    public String getHotArticles(@PathVariable String keyword) {
        return new JSONArray(articleService.findFreshHotArticle(keyword)).toString();
    }

    @GetMapping("/getArticleDetail/{id}")
    public String getHotArticles(@PathVariable int id) {
        return new JSONObject(articleService.findArticleById(id)).toString();
    }
}
