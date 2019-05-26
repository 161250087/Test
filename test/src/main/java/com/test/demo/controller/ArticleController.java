package com.test.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ArticleController {


    /**
     *@Author : LML
     *@Date : 15:49 2019/5/26
     *@Desciption : 查询所有文章的数量
     */
    @GetMapping("/getTotal")
    public int getAllArticlesCount(){
        return 0;
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
        return null;
    }




    @GetMapping("/getTotalByKeyword/{keyoword}")
    public int getAllArticlesCount(@PathVariable String keyword){
        return 0;
    }

    @GetMapping("/getArticlesByKeyword/{index}")
    public String getArticesByIndexAndKeyword(@PathVariable int index){
        return null;
    }



    @GetMapping("/getTotalByKTag/{keyoword}")
    public int getAllArticlesCountByTag(@PathVariable String keyword){
        return 0;
    }

    @GetMapping("/getArticlesByTag/{index}")
    public String getArticesByIndexAndTag(@PathVariable int index){
        return null;
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
        return null;
    }
}
