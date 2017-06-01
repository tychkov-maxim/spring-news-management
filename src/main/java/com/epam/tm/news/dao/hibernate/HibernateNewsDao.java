package com.epam.tm.news.dao.hibernate;

import com.epam.tm.news.dao.NewsDao;
import com.epam.tm.news.entity.News;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("HibernateDao")
public class HibernateNewsDao extends HibernateDao<News> implements NewsDao {

    private static final String ALL_NEWS_HQL_QUERY = "from News order by date";
    
    @Override
    public News fetchById(long id) {
        return sessionFactory.getCurrentSession().get(News.class,id);
    }

    @Override
    public List<News> getAllNewsOrderByDate() {
        Query query = sessionFactory.getCurrentSession().createQuery(ALL_NEWS_HQL_QUERY);
        return query.list();
    }
}
