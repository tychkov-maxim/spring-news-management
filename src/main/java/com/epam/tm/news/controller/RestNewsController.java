package com.epam.tm.news.controller;

import com.epam.tm.news.entity.News;
import com.epam.tm.news.service.NewsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "rest/news", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RestNewsController implements NewsController {

    @Autowired
    private NewsService newsService;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllNewsByDate() throws ControllerException {
        try {
            String json = mapper.writeValueAsString(newsService.getAllNewsByDate());
            return json;
        } catch (JsonProcessingException e) {
            throw new ControllerException(e);
        }
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getNewsById(@PathVariable("id") long id) throws ControllerException {

        try {
            String json = mapper.writeValueAsString(newsService.getNewsById(id));
            return json;
        } catch (JsonProcessingException e) {
            throw new ControllerException(e);
        }

    }

    @Override
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteNews(@RequestBody News news) throws ControllerException {
        newsService.deleteNewsById(news);
        return "";
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNews(@RequestBody  News news) throws ControllerException {
        News savedNews = newsService.saveNews(news);
        try {
            String json = mapper.writeValueAsString(savedNews);
            return json;
        } catch (JsonProcessingException e) {
            throw new ControllerException(e);
        }


    }

    @Override
    @RequestMapping(value = "/deleteList", method = RequestMethod.POST)
    public String deleteList(@RequestBody  long [] ids) {
        for (long id : ids) {
            News news = new News();
            news.setId(id);
            newsService.deleteNewsById(news);
        }
        return "";
    }

}
