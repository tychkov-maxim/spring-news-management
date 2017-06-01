package com.epam.tm.news.service;

import com.epam.tm.news.dao.NewsDao;
import com.epam.tm.news.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsService {

    @Autowired
    @Qualifier("HibernateDao")
    private NewsDao newsDao;


    public List<News> getAllNewsByDate(){
           return newsDao.getAllNewsOrderByDate();
    }

    public void deleteNewsById(News news){
        newsDao.remove(news);
    }

    public News getNewsById(long id){
        return newsDao.fetchById(id);
    }

    public News saveNews(News news){
        return newsDao.save(news);
    }
}
