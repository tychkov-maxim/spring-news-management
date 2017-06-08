package com.epam.tm.news.soap;

import com.epam.tm.news.entity.News;
import com.epam.tm.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(endpointInterface = "com.epam.tm.news.soap.NewsSoapInterface", serviceName = "News")
public class SoapNewsEndPoint implements NewsSoapInterface<News>{

    @Autowired
    private NewsService newsService;

    @Override
    @WebMethod
    public List<News> getAllNewsByDate() {
        return newsService.getAllNewsByDate();
    }

    @Override
    @WebMethod
    public News getNewsById(@WebParam(name = "arg0") long id) {
        return newsService.getNewsById(id);
    }

    @Override
    @WebMethod
    public void deleteNewsById(long id) {
        News news = new News();
        news.setId(id);
        newsService.deleteNewsById(news);
    }

    @Override
    @WebMethod
    public News saveNews(News news) {
        return newsService.saveNews(news);
    }

    @Override
    @WebMethod
    public void deleteList(List<Long> ids) {
        for (Long id : ids) {
            News news = new News();
            news.setId(id);
            newsService.deleteNewsById(news);
        }
    }
}
