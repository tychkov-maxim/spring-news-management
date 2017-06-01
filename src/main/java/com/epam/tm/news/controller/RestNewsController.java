package com.epam.tm.news.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/news", produces = MediaType.ALL_VALUE)
public class RestNewsController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String helloWorld(){
        return "HelloWorld! It's REST!";
    }
}
