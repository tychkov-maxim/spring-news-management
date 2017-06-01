package com.epam.tm.news.dao;

import com.epam.tm.news.entity.News;

import java.util.List;

public interface NewsDao extends Dao<News> {
    List getAllNewsOrderByDate();
}
