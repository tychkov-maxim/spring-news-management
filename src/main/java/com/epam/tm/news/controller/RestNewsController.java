package com.epam.tm.news.controller;

import com.epam.tm.news.entity.News;
import com.epam.tm.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "rest/news", produces = MediaType.ALL_VALUE)
public class RestNewsController {

    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String helloWorld(@PathVariable("id") long id){

        List<News> allNewsByDate = newsService.getAllNewsByDate();

        StringBuilder stringBuilder = new StringBuilder();
        for (News news : allNewsByDate) {
            stringBuilder.append(news);
            stringBuilder.append("</br>");
        }
        return stringBuilder.toString();
    }
}
