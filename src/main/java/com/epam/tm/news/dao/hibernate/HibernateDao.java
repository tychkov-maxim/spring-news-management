package com.epam.tm.news.dao.hibernate;

import com.epam.tm.news.dao.Dao;
import com.epam.tm.news.entity.BaseEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class HibernateDao<T extends BaseEntity> implements Dao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public T save(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void remove(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

}
