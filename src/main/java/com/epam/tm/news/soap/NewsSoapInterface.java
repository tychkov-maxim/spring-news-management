package com.epam.tm.news.soap;

import com.epam.tm.news.controller.ControllerException;
import com.epam.tm.news.entity.BaseEntity;
import com.epam.tm.news.entity.News;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface NewsSoapInterface<T extends BaseEntity> {
    List<T> getAllNewsByDate();
    T getNewsById(long id);
    void deleteNewsById(long id);
    T saveNews(News news);
    void deleteList(List<Long> ids);
}
