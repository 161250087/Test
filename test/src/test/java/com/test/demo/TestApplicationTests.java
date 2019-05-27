package com.test.demo;

import com.test.demo.controller.ArticleController;
import com.test.demo.controller.LoginController;
import com.test.demo.dao.*;
import com.test.demo.entity.*;
import com.test.demo.service.LoginService;
import com.test.demo.serviceImpl.ArticleServiceImpl;
import com.test.demo.serviceImpl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;


//最后的测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
    @Autowired
    public LoginService loginService;
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public ArticleServiceImpl articleService;
    @Autowired
    public ArticleDao articleDao;
    @Autowired
    public UserDao userDao;

    @Autowired
    public Article_tagDao article_tagDao;

    @Autowired
    public CollectionDao collectionDao;

    @Autowired
    public SubscribeDao subscribeDao;

    @Autowired
    public User_tagDao user_tagDao;

    @Autowired
    public LoginController loginController;

    @Autowired
    public ArticleController articleController;

    //entity_User
    @Test
    public void teste1() throws Exception {
        User u = new User();
        u.setId(1);
        u.setName("阿三");
        u.setPassword("123456");
        Assert.assertEquals(u.getId(), 1);
        Assert.assertEquals(u.getName(), "阿三");
        Assert.assertEquals(u.getPassword(), "123456");
    }

    //entity_User_tag
    @Test
    public void teste2()throws Exception {
        User_tag ug = new User_tag();
        ug = new User_tag(2, "体育");
        ug.setUser_id(2);
        ug.setTag("体育");
        Assert.assertEquals(ug.getUser_id(), 2);
        Assert.assertEquals(ug.getTag(), "体育");
    }

    //entity_Subscribe
    @Test
    public void teste3()throws Exception {
        Subscribe sub = new Subscribe();
        sub = new Subscribe("vic", 2);
        sub.setUser_id(3);
        sub.setAuthor("Vic");
        Assert.assertEquals(sub.getUser_id(), 3);
        Assert.assertEquals(sub.getAuthor(), "Vic");
    }

    //entity_Collection
    @Test
    public void teste4() throws Exception {
        Collection col = new Collection();
        col = new Collection(4, 5);
        col.setUser_id(4);
        col.setArticle_id(5);
        Assert.assertEquals(col.getUser_id(), 4);
        Assert.assertEquals(col.getArticle_id(), 5);
    }

    //entity_Article_tag
    @Test
    public void teste5() {
        Article_tag at = new Article_tag();
        at = new Article_tag(100, "物理");
        at.setArticle_id(6);
        at.setTag("物理");
        Assert.assertEquals(at.getArticle_id(), 6);
        Assert.assertEquals(at.getTag(), "物理");
    }

    //entity_Article
    @Test
    public void teste6(){
        Article a = new Article();
        a = new Article("madi","madi","madi",13,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-05-25 16:10:46"),Timestamp.valueOf("2019-05-25 16:21:46"));
        //set
        a.setAuthor("马帝");
        a.setTitle("马帝演唱会");
        a.setContent("马帝在宿舍唱几首歌。");
        a.setHot(100);
        a.setPublish_time(Timestamp.valueOf("2019-05-25 16:01:46"));
        a.setStart(Timestamp.valueOf("2019-05-30 16:00:00"));
        a.setEnd(Timestamp.valueOf("2019-05-30 18:00:00"));
       //get
        Assert.assertEquals(a.getAuthor(),"马帝");
        Assert.assertEquals(a.getTitle(),"马帝演唱会");
        Assert.assertEquals(a.getContent(),"马帝在宿舍唱几首歌。");
        Assert.assertEquals(a.getHot(),100);
        Assert.assertEquals(a.getPublish_time(),Timestamp.valueOf("2019-05-25 16:01:46"));
        Assert.assertEquals(a.getStart(),Timestamp.valueOf("2019-05-30 16:00:00"));
        Assert.assertEquals(a.getEnd(),Timestamp.valueOf("2019-05-30 18:00:00"));
    }

 /*   //data
    @Test
    public void test1(){
        //Article
        articleDao.addArticle("碳基材料及其锂硫电池应用","地点：化学楼C308","李峰",5,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-05-30 10:00:00"),Timestamp.valueOf("2019-05-30 12:00:00"));
        articleDao.addArticle("有机金属大环和笼状化合物及其应用","地点：化学化工学院A216室","金国新",5,Timestamp.valueOf("2019-05-25 16:00:00"),Timestamp.valueOf("2019-05-31 10:00:00"),Timestamp.valueOf("2019-05-31 12:00:00"));
        articleDao.addArticle("汉诗、雅集与东亚汉文化圈的余韵","地点：国际学院C308高研院报告厅","卞东波",5,Timestamp.valueOf("2019-05-24 15:01:46"),Timestamp.valueOf("2019-06-01 10:00:00"),Timestamp.valueOf("2019-06-01 12:00:00"));
        articleDao.addArticle("幽默的理论机制、个别差异与教育实践","地点：社会学院401室","周仁来",5,Timestamp.valueOf("2019-05-23 16:01:46"),Timestamp.valueOf("2019-06-10 10:00:00"),Timestamp.valueOf("2019-06-10 12:00:00"));
        articleDao.addArticle("Future Mobility: Cloud-Enabled Automotive Decision-Making Systems","地点：计算机科学与技术楼230室","Zhaojian Li",40,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-05-31 14:00:00"),Timestamp.valueOf("2019-05-31 16:00:00"));
        articleDao.addArticle("英国殖民主义及其影响","地点：仙I–207","郑佳雯",5,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-05-28 10:00:00"),Timestamp.valueOf("2019-05-28 12:00:00"));
        articleDao.addArticle("信息失序背景下的信息素养","地点：仙II-103","法赫",5,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-05-27 10:00:00"),Timestamp.valueOf("2019-05-27 12:00:00"));
        articleDao.addArticle("中埃文化交流的历史考察","地点：仙II-310","莫尔森",5,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-05-29 10:00:00"),Timestamp.valueOf("2019-05-29 12:00:00"));
        articleDao.addArticle("边缘人群的研究方法与伦理思考","地点：社会学院422室","黄盈盈",5,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-06-02 10:00:00"),Timestamp.valueOf("2019-06-02 12:00:00"));
        articleDao.addArticle("The Strong Program in Cultural Sociology","地点：社会学院324室","Todd Madigan",5,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-05-31 8:00:00"),Timestamp.valueOf("2019-05-31 10:00:00"));
        articleDao.addArticle("美国政界的犹太人：20世纪30年代到90年代","地点：哲学楼446室","Fred A. Lazin",5,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-05-31 18:00:00"),Timestamp.valueOf("2019-05-31 20:00:00"));
        articleDao.addArticle("草地音乐节","地点：炜华体育场","草地音乐节主办方",5,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-05-31 19:00:00"),Timestamp.valueOf("2019-05-31 22:00:00"));
        articleDao.addArticle("南大杯足球决赛","地点：炜华体育场","南大足球队",5,Timestamp.valueOf("2019-05-25 16:01:46"),Timestamp.valueOf("2019-06-01 12:00:00"),Timestamp.valueOf("2019-06-01 14:00:00"));
    }
*/

    //LoginService
    @Test
    public void testl(){
        User u0 = new User("vic","123456");
        Assert.assertEquals(loginService.loginConfig(u0),2);
        User u1 = new User("vic11","123456");
        Assert.assertEquals(loginService.loginConfig(u1),-1);
        Assert.assertEquals(loginService.findUserById(1).getName(),"123");
        Assert.assertEquals(loginService.addUser(u0),-1);
        Assert.assertEquals(loginService.addUser(u1),1);
        Assert.assertEquals(loginService.findUserByName("vic"),-1);
        userDao.deleteUser("vic11");
        Assert.assertEquals(loginService.findUserByName("vic11"),1);

    }

    //UserService_Tag
    @Test
    public void testu1() {
        Assert.assertEquals(userService.getAllArticle().size(), 91);
        Assert.assertEquals(userService.getArticleNum(), 91);
        Assert.assertEquals(userService.getAllArticlePage(0, 5).get(0).getId(), 1);
        Assert.assertEquals(userService.getAllArticlePage(0, 5).size(), 5);
        Assert.assertEquals(userService.addTag(3, "体育"), 1);
        Assert.assertEquals(userService.addTag(3, "体育"), -1);
        userService.deleteTag(3, "体育");
        Assert.assertEquals(userService.addTag(3, "体育"), 1);
        Assert.assertEquals(userService.getAllTag().size(), 1);
        Assert.assertEquals(userService.getMyTag(3).size(), 1);
        userService.deleteTag(3, "体育");
    }

    //UserService_Collection
    @Test
    public void testu2() {
        Assert.assertEquals(userService.addCollection(3, 1), 1);
        Assert.assertEquals(userService.addCollection(3, 1), -1);
        userService.deleteCollection(3, 1);
        Assert.assertEquals(userService.addCollection(3, 1), 1);
        Assert.assertEquals(userService.getMyCollection(3).size(), 1);
        Assert.assertEquals(userService.getMyFreshCollection(3).size(), 0);
        userService.deleteCollection(3, 1);
        Assert.assertEquals(userService.addCollection(3, 19), 1);
        Assert.assertEquals(userService.addCollection(3, 19), -1);
        userService.deleteCollection(3, 19);
        Assert.assertEquals(userService.addCollection(3, 19), 1);
        Assert.assertEquals(userService.getMyCollection(3).size(), 1);
        Assert.assertEquals(userService.getMyFreshCollection(3).size(), 1);
        userService.deleteCollection(3, 19);
    }

    //UserService_Subscribe
    @Test
    public void testu3(){
        Assert.assertEquals(userService.addSubscribe(3,"李峰"),1);
        Assert.assertEquals(userService.addSubscribe(3,"李峰"),-1);
        userService.deleteSubscribe(3,"李峰");
        Assert.assertEquals(userService.addSubscribe(3,"李峰"),1);
        Assert.assertEquals(userService.getMySubscribe(3).size(),1);
        Assert.assertEquals(userService.getMySubscribe_Article(3).size(),7);
        Assert.assertEquals(userService.getMyFreshSubscribe_Article(3).size(),6);
        userService.deleteSubscribe(3,"李峰");
    }

    //UserService_Message
    @Test
    public void testu4(){
        Assert.assertEquals(userService.remindMessage(1).get(0).getId(),23);
        Assert.assertEquals(userService.remindMessage(1).get(1).getId(),29);
        Assert.assertEquals(userService.hotPush(1).size(),5);
        Assert.assertEquals(userService.hotPush(4).size(),5);
        Assert.assertEquals(userService.hotPush(5).size(),5);
        Assert.assertEquals(userService.hotPush(18).size(),5);
    }

    //ArticleService
    @Test
    public void testa() {
        //热点
        articleService.AddHot(1);
        Assert.assertEquals(articleDao.findById(1).getHot(), articleDao.findById(1).getHot());
        Assert.assertEquals(articleService.findArticle("体育").size(), 5);
        Assert.assertEquals(articleService.findFreshArticle("体育").size(), 5);
        Assert.assertEquals(articleService.findArticleNum("体育"), 5);
        Assert.assertEquals(articleService.findFreshArticleNum("李峰"), 7);
        Assert.assertEquals(articleService.freshArticle().size(), 82);
        Assert.assertEquals(articleService.allArticle().size(), 91);
        Assert.assertEquals(articleService.findArticle("李峰").size(),8);
        Assert.assertEquals(articleService.findFreshArticle("李峰").size(),7);
        Assert.assertEquals(articleService.findArticlePage("李峰",0,5).get(0).getTitle(),"碳基材料及其锂硫电池应用");
        Assert.assertEquals(articleService.findFreshArticlePage("李峰",0,5).get(2).getTitle(),"碳基材料及其锂硫电池应用");
        Assert.assertEquals(articleService.findHotArticle("李峰").get(0).getHot(),55);
        Assert.assertEquals(articleService.findFreshHotArticle("李峰").get(0).getId(),31);
        Assert.assertEquals(articleService.findArticleById(1).getAuthor(),"李峰");
        Assert.assertEquals(articleService.freshArticleNum(),82);
        Assert.assertEquals(articleService.freshArticlePage(0,5).get(0).getId(),19);
    }

    //LoginController
    @Test
    public void testlc(){
        Assert.assertEquals(loginController.login("lml","123"),34);
        loginController.register("mdlz","123");
        Assert.assertEquals(loginController.login("mdlz","123"),37);
        Assert.assertEquals(loginController.checkUserName("lml"),true);
        Assert.assertEquals(loginController.checkUserName("lml123yt"),false);
    }

    //ArticleController
    @Test
    public void testac(){
        Assert.assertEquals(articleController.getAllArticlesCount(),82);
        articleController.getArticesByIndex(1);
        Assert.assertEquals(articleController.getAllArticlesCount(),82);
        articleController.getArticesByIndexAndKeyword("哲学",5);
        articleController.getHotArticles("社会");
;       //articleController.getArticleDetail(20);
        Assert.assertEquals(articleController.addInterset(35,"李峰"),-1);
        //Assert.assertEquals(articleController.addCollection(35,81),1);
        Assert.assertEquals(articleController.getCollectionCount(1),2);
        articleController.getCollection(1);
        articleController.getConcern(1);
        articleController.getMessage(1);
       articleController. getArticleTags(1);
       articleController.getRecommend(1);
        articleController.getAllArticlesCount("F");
        articleController.getAllArticlesCountByTag("F");
        articleController.getArticesByIndexAndTag("体育",0);
    }
}
