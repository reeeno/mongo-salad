package com.knowhere.mongosalad.controller;

import com.knowhere.mongosalad.dao.NewsApiRepository;
import com.knowhere.mongosalad.model.NewsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/newsApi")
public class NewsApiController {

    @Autowired
    private NewsApiRepository newsApiRepository;

    @GetMapping
    public List<NewsApi> getAll() {
        return newsApiRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<NewsApi> add(@RequestBody List<NewsApi> newsApis) {
        List<NewsApi> response = new ArrayList<>();
        newsApis.forEach((newsApi) -> response.add(newsApiRepository.save(newsApi)));
        return response;
    }

}
