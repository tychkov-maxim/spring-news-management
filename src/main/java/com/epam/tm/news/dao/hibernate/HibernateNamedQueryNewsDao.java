package com.epam.tm.news.dao.hibernate;

import com.epam.tm.news.dao.NewsDao;
import com.epam.tm.news.entity.News;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static com.epam.tm.news.constant.ConstantHolder.*;


@Repository
@Qualifier("HibernateNamedQueryDao")
public class HibernateNamedQueryNewsDao extends HibernateNamedQueryDao<News> implements NewsDao {
    @Override
    public News save(News entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query;
        if (entity.getId() != 0) {
            query = currentSession.getNamedNativeQuery(UPDATE_NEWS_NAMED_QUERY);
            query.setParameter(ID, entity.getId());
        } else
            query = currentSession.getNamedNativeQuery(INSERT_NEWS_NAMED_QUERY);
        query.setParameter(DATE_TIME_PARAMETER, entity.getDate());
        query.setParameter(TITLE_TIME_PARAMETER, entity.getTitle());
        query.setParameter(BRIEF_TIME_PARAMETER, entity.getBrief());
        query.setParameter(CONTENT_TIME_PARAMETER, entity.getContent());
        query.executeUpdate();
        entity.setId(getLastId());
        return entity;
    }

    @Override
    public List<News> getAllNewsOrderByDate() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query getListByDate = currentSession.getNamedQuery(LIST_BY_DATE_NAMED_QUERY);
        return getListByDate.list();
    }

    private long getLastId(){
        Session currentSession = sessionFactory.getCurrentSession();
        Query lastIdQuery = currentSession.getNamedQuery(LAST_ID_NAMED_QUERY);
        return ((BigDecimal)lastIdQuery.uniqueResult()).longValue();
    }
}
