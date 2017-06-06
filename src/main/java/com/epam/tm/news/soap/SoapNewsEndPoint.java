package com.epam.tm.news.soap;

import com.epam.tm.news.entity.News;
import com.epam.tm.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.jws.WebMethod;
import javax.jws.WebService;

@Component
@WebService(endpointInterface = "com.epam.tm.news.soap.NewsSoapInterface", serviceName = "news")
public class SoapNewsEndPoint implements NewsSoapInterface{

    @Autowired
    private NewsService newsService;


    @Override
    @WebMethod
    public News getAllNewsByDate() {
        return newsService.getNewsById(109);
    }
}
