package com.epam.tm.news;

import com.epam.tm.news.service.NewsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class TestService {

    @Autowired
    NewsService newsService;

    @Test
    public void newsServiceShouldWork() throws Exception {
        Assert.assertNotNull(newsService);
    }
}
