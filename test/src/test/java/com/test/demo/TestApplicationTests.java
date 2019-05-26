package com.test.demo;

import com.test.demo.dao.*;
import com.test.demo.entity.*;
import com.test.demo.serviceImpl.ArticleServiceImpl;
import com.test.demo.serviceImpl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
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

    //entity
    @Test
    public void test() throws Exception{
        //User
        User u = new User();
        u.setId(1);
        u.setName("阿三");
        u.setPassword("123456");
        Assert.assertEquals(u.getId(),1);
        Assert.assertEquals(u.getName(),"阿三");
        Assert.assertEquals(u.getPassword(),"123456");
        //User_tag
        User_tag ug = new User_tag();
        ug.setUser_id(2);
        ug.setTag("体育");
        Assert.assertEquals(ug.getUser_id(),2);
        Assert.assertEquals(ug.getTag(),"体育");
        //Subscribe
        Subscribe sub = new Subscribe();
        sub.setUser_id(3);
        sub.setAuthor("Vic");
        Assert.assertEquals(sub.getUser_id(),3);
        Assert.assertEquals(sub.getAuthor(),"Vic");
        //Collection
        Collection col = new Collection();
        col.setUser_id(4);
        col.setArticle_id(5);
        Assert.assertEquals(col.getUser_id(),4);
        Assert.assertEquals(col.getUser_id(),5);
        //Article_tag
        Article_tag at = new Article_tag();
        at.setArticle_id(6);
        at.setTag("物理");
        Assert.assertEquals(at.getArticle_id(),6);
        Assert.assertEquals(at.getTag(),"体育");
        //Article
        Article a = new Article();
        a.setAuthor("马帝");
        a.setTitle("马帝演唱会");
        a.setContent("马帝在宿舍唱几首歌。");
        a.setHot(100);
        a.setPublish_time(Timestamp.valueOf("2019-05-25 16:01:46"));
        a.setStart(Timestamp.valueOf("2019-05-30 16:00:00"));
        a.setEnd(Timestamp.valueOf("2019-05-30 18:00:00"));
        Assert.assertEquals(a.getAuthor(),"马帝");
        Assert.assertEquals(a.getTitle(),"马帝演唱会");
        Assert.assertEquals(a.getContent(),"马帝在宿舍唱几首歌。");
        Assert.assertEquals(a.getHot(),100);
        Assert.assertEquals(a.getPublish_time(),Timestamp.valueOf("2019-05-25 16:01:46"));
        Assert.assertEquals(a.getStart(),Timestamp.valueOf("2019-05-30 16:00:00"));
        Assert.assertEquals(a.getEnd(),Timestamp.valueOf("2019-05-30 18:00:00"));
    }

    //data
    @Test
    public void test1() throws  Exception{
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
        //User
        userDao.addUser("vic","123456");
        userDao.addUser("andy","123456");
        userDao.addUser("duck","654321");
        userDao.addUser("madi","123madi");
        //

    }

    @Test
    public void test2() throws  Exception{
        Timestamp timeStamp = new Timestamp(new Date().getTime());
        articleDao.addArticle("题目1","内容1","作者1",5,timeStamp,timeStamp,timeStamp);
        articleDao.addArticle("题目2","内容2","作者2",15,timeStamp,timeStamp,timeStamp);
        articleDao.addArticle("题目3","内容3","作者3",7,timeStamp,timeStamp,timeStamp);
        //System.out.print(articleDao.findAll().get(0).getAuthor());
        //collectionDao.deleteCollection(1,2);
        //article_tagDao.addArticle_tag(1,"运动1");
        //subscribeDao.addSubscribe(1,"作者1");
        //user_tagDao.addUser_tag(1,"运动1");
        //articleService.AddHot(1);
    }
}
