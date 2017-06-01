package com.epam.tm.news.controller;

import com.epam.tm.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "rest/news", produces = MediaType.ALL_VALUE)
public class RestNewsController {

    @Autowired
    NewsService newsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String helloWorld(){
        return newsService.getAllNewsByDate().get(0).getBrief();
    }
}
