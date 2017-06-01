package com.epam.tm.news.dao.hibernate;

import com.epam.tm.news.dao.Dao;
import com.epam.tm.news.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import static com.epam.tm.news.constant.ConstantHolder.*;

public abstract class HibernateNamedQueryDao<T extends BaseEntity> implements Dao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public T fetchById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
            Query selectQuery = currentSession.getNamedQuery(FIND_NEWS_BY_ID_NAMED_QUERY);
            selectQuery.setParameter(ID,id);
            return (T) selectQuery.uniqueResult();

    }

    @Override
    public void remove(T entity) {
       Session currentSession = sessionFactory.getCurrentSession();
            Query deleteQuery = currentSession.getNamedQuery(DELETE_NEWS_NAMED_QUERY);
            deleteQuery.setParameter(ID, entity.getId());
            deleteQuery.executeUpdate();
    }
}
