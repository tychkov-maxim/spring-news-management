package com.epam.tm.news.controller;

import com.epam.tm.news.entity.News;
import org.springframework.http.ResponseEntity;

public interface NewsController<T> {
    T getAllNewsByDate() throws ControllerException;
    T getNewsById(long id) throws ControllerException;
    T deleteNewsById(long id) throws ControllerException;
    T saveNews(News news) throws ControllerException;
    T deleteList(long ids[]);
}
