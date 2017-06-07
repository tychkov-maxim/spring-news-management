package com.epam.tm.news.controller;

import com.epam.tm.news.entity.News;
import com.epam.tm.news.service.NewsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "rest/news", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RestNewsController implements NewsController<ResponseEntity> {

    @Autowired
    private NewsService newsService;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity getAllNewsByDate() throws ControllerException {
        try {
            List<News> allNewsByDate = newsService.getAllNewsByDate();

            if (allNewsByDate.size() == 0)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            String json = mapper.writeValueAsString(allNewsByDate);
            return new ResponseEntity<>(json, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new ControllerException(e);
        }
    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity getNewsById(@PathVariable("id") long id) throws ControllerException {

        try {

            News newsById = newsService.getNewsById(id);
            if (newsById == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            String json = mapper.writeValueAsString(newsById);
            return new ResponseEntity<>(json,HttpStatus.OK);

        } catch (JsonProcessingException e) {
            throw new ControllerException(e);
        }

    }

    @Override
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteNewsById(@PathVariable("id") long id) throws ControllerException {
        News news = new News();
        news.setId(id);
        newsService.deleteNewsById(news);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveNews(@RequestBody  News news) throws ControllerException {
        try {
            News savedNews = newsService.saveNews(news);
            String json = mapper.writeValueAsString(savedNews);
            return new ResponseEntity<>(json, HttpStatus.OK);

        } catch (JsonProcessingException e) {
            throw new ControllerException(e);
        }


    }

    @Override
    @RequestMapping(value = "/deleteList", method = RequestMethod.DELETE)
    public ResponseEntity deleteList(@RequestBody  long [] ids) {
        for (long id : ids) {
            News news = new News();
            news.setId(id);
            newsService.deleteNewsById(news);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
