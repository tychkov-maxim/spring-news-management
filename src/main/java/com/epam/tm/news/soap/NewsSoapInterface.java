package com.epam.tm.news.soap;

import com.epam.tm.news.entity.News;

import javax.jws.WebService;

@WebService
public interface NewsSoapInterface {
    News getAllNewsByDate();
}
