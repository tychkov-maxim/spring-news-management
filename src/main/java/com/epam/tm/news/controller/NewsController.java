package com.epam.tm.news.controller;

import com.epam.tm.news.entity.News;

public interface NewsController {
    String getAllNewsByDate() throws ControllerException;
    String getNewsById(long id) throws ControllerException;
    String deleteNews(News news) throws ControllerException;
    String saveNews(News news) throws ControllerException;
    String deleteList(long ids[]);
}
