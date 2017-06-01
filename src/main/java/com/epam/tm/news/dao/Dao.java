package com.epam.tm.news.dao;

import com.epam.tm.news.entity.BaseEntity;


public interface Dao <T extends BaseEntity> {
    T save(T entity);

    T fetchById(long id);

    void remove(T entity);
}
